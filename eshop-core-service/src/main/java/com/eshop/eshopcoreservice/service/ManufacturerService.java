package com.eshop.eshopcoreservice.service;

import com.eshop.eshopcoreservice.entity.ManufacturerEntity;

import java.util.List;

public interface ManufacturerService {
    List<ManufacturerEntity> getAllManufacturer();
    ManufacturerEntity getManufacturerById(Long id);
    ManufacturerEntity createManufacturer(ManufacturerEntity manufacturer);
    ManufacturerEntity updateManufacturer(Long id, ManufacturerEntity manufacturer);
    void deleteManufacturer(Long id);
}
