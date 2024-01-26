package com.eshop.eshopcoreservice.repository;

import com.eshop.eshopcoreservice.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    List<CategoryEntity> findByDeletedFalse();
    Optional<CategoryEntity> findByIdAndDeletedFalse(Long id);
}
