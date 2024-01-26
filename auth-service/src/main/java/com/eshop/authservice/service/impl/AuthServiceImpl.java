package com.eshop.authservice.service.impl;

import com.eshop.authservice.dto.*;
import com.eshop.authservice.entity.RoleEntity;
import com.eshop.authservice.entity.UserEntity;
import com.eshop.authservice.exception.ServiceExceptionHandler;
import com.eshop.authservice.repository.RoleRepository;
import com.eshop.authservice.repository.UserRepository;
import com.eshop.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public SuccessResponse login(LoginDto loginDto) {
        UserEntity user = userRepository.findByPhoneOrEmail(loginDto.getPhoneOrEmail(), loginDto.getPhoneOrEmail()).orElseThrow(() -> new ServiceExceptionHandler(HttpStatus.BAD_REQUEST, "Email or Phone was in correct!."));

        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new ServiceExceptionHandler(HttpStatus.UNAUTHORIZED, "Password was in correct!.");
        }

        return new SuccessResponse(true, "Your login was successfully!");
    }

    @Override
    public SuccessResponse register(RegisterDto registerDto) throws ServiceExceptionHandler {

        if (userRepository.existsByPhone(registerDto.getPhone())) {
            throw new ServiceExceptionHandler(HttpStatus.NOT_FOUND, "Phone is already exists!.");
        }

        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new ServiceExceptionHandler(HttpStatus.NOT_FOUND, "Email is already exists!.");
        }

        UserEntity user = new UserEntity();

        user.setPhone(registerDto.getPhone());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());

        Set<RoleEntity> roles = new HashSet<>();

        RoleEntity userRole = roleRepository.findByName("USER").orElse(null);

        if (userRole == null) {
            RoleEntity role = new RoleEntity();
            role.setName("USER");
            role.setRoleDescription("DEFAULT USER");
            roles.add(roleRepository.save(role));
        }
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return new SuccessResponse(true, "Your account signup was successful!.");
    }

    @Override
    public SuccessResponse forgotPassword(ForgotPasswordDto forgotPasswordDto) {
        return null;
    }

    @Override
    public SuccessResponse resetPassword(String passwordResetToken, ResetPasswordDto resetPasswordDto) {
        return null;
    }
}
