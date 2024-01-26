package com.eshop.eshopcoreservice.service;

import com.eshop.eshopcoreservice.entity.AddressEntity;
import com.eshop.eshopcoreservice.entity.ManufacturerEntity;

import java.util.List;

public interface AddressService {
    List<AddressEntity> getAllAddress();
    AddressEntity getAddressById(Long id);
    AddressEntity saveAddress(AddressEntity address);
    AddressEntity updateAddress(Long id, AddressEntity address);
    void deleteAddress(Long id);
}
