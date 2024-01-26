package com.eshop.eshopcoreservice.repository;

import com.eshop.eshopcoreservice.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity,Long> {
    List<ManufacturerEntity> findByDeletedFalse();
    Optional<ManufacturerEntity> findByIdAndDeletedFalse(Long id);
}
