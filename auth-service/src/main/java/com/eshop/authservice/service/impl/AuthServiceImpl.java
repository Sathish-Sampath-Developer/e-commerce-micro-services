package com.eshop.authservice.service.impl;

import com.eshop.authservice.dto.*;
import com.eshop.authservice.entity.RoleEntity;
import com.eshop.authservice.entity.UserEntity;
import com.eshop.authservice.exception.ServiceException;
import com.eshop.authservice.repository.RoleRepository;
import com.eshop.authservice.repository.UserRepository;
import com.eshop.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        UserEntity user = userRepository.findByPhoneOrEmail(loginDto.getPhoneOrEmail(), loginDto.getPhoneOrEmail()).orElseThrow(() -> new ServiceException(HttpStatus.BAD_REQUEST, "Email or Phone was in correct!."));

        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new ServiceException(HttpStatus.UNAUTHORIZED, "Password was in correct!.");
        }

        return new SuccessResponse(true, "Your login was successfully!");
    }

    @Override
    public SuccessResponse register(RegisterDto registerDto) {

        if (userRepository.existsByPhone(registerDto.getPhone())) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Phone is already exists!.");
        }

        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        UserEntity user = new UserEntity();

        user.setPhone(registerDto.getPhone());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());

        if (user.getRoles().isEmpty()) {
            RoleEntity defaultRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "Default role not found!"));
            user.setRoles(Collections.singleton(defaultRole));
        }

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
