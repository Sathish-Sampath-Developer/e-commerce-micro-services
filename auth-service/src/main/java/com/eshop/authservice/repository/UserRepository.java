package com.eshop.authservice.repository;

import com.eshop.authservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByPhoneOrEmail(String phone, String email);

    Boolean existsByPhone(String phone);

    Boolean existsByEmail(String email);
}
