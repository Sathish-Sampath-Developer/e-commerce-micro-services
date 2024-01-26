package com.eshop.authservice.service.impl;

import com.eshop.authservice.entity.RoleEntity;
import com.eshop.authservice.exception.ServiceExceptionHandler;
import com.eshop.authservice.repository.RoleRepository;
import com.eshop.authservice.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleEntity createRole(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }

    @Override
    public List<RoleEntity> getListOfRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new ServiceExceptionHandler(HttpStatus.NOT_FOUND, "Role was not found given id"));
    }

    @Override
    public RoleEntity updateRole(Long id, RoleEntity roleEntity) {

        RoleEntity role = roleRepository.findById(id).orElseThrow(() -> new ServiceExceptionHandler(HttpStatus.NOT_FOUND, "Role was not found given id"));
        role.setRoleDescription(roleEntity.getRoleDescription());
        role.setName(roleEntity.getName());

        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        RoleEntity role = roleRepository.findById(id).orElseThrow(() -> new ServiceExceptionHandler(HttpStatus.NOT_FOUND, "Role was not found given id"));
        roleRepository.delete(role);
    }
}
