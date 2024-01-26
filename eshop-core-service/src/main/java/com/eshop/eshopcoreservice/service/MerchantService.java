package com.eshop.eshopcoreservice.service;

import com.eshop.eshopcoreservice.dto.MerchantStoreDto;

import java.util.List;

public interface MerchantService {
    MerchantStoreDto createMerchant(MerchantStoreDto merchantStoreDto);

    List<MerchantStoreDto> getMerchantList();

    MerchantStoreDto getMerchantById(long id);

    MerchantStoreDto updateMerchant(long id, MerchantStoreDto merchantStoreDto);

    void deleteMerchant(long id);
}
