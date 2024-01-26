package com.eshop.authservice.controller;

import com.eshop.authservice.entity.RoleEntity;
import com.eshop.authservice.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/private/auth/roles")
@AllArgsConstructor
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleEntity> createUser(@RequestBody RoleEntity role){
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
}
