package com.eshop.eshopcoreservice.repository;

import com.eshop.eshopcoreservice.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
    List<AddressEntity> findByDeletedFalse();

    Optional<AddressEntity> findByIdAndDeletedFalse(Long id);
}
