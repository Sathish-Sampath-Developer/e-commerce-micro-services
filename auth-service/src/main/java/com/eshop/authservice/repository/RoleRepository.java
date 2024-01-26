package com.eshop.authservice.repository;

import com.eshop.authservice.entity.RoleEntity;
import com.eshop.authservice.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByName(String name);

}
