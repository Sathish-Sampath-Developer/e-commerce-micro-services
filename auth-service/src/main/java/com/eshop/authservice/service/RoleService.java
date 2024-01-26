package com.eshop.authservice.service;

import com.eshop.authservice.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    RoleEntity createRole(RoleEntity roleEntity);

    List<RoleEntity> getListOfRoles();

    RoleEntity getRoleById(Long id);

    RoleEntity updateRole(Long id, RoleEntity roleEntity);

    void deleteRole(Long id);
}
