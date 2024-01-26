package com.eshop.eshopcustomerservice.repository;

import com.eshop.eshopcustomerservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
