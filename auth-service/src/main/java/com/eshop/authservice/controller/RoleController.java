package com.eshop.authservice.controller;

import com.eshop.authservice.entity.RoleEntity;
import com.eshop.authservice.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Roles Controller", description = "This url for handle roles in  E-Shop.")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleEntity> createUser(@RequestBody RoleEntity role){
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
}
