package com.eshop.eshopcoreservice.repository;

import com.eshop.eshopcoreservice.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity,Long> {
    Optional<ShoppingCartEntity> findByCustomerId(Long id);
}
