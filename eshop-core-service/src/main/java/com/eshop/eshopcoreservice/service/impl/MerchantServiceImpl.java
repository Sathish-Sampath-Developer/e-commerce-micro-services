package com.eshop.eshopcoreservice.service.impl;

import com.eshop.eshopcoreservice.dto.MerchantStoreDto;
import com.eshop.eshopcoreservice.entity.MerchantStoreEntity;
import com.eshop.eshopcoreservice.exception.ServiceException;
import com.eshop.eshopcoreservice.mapper.MerchantMapper;
import com.eshop.eshopcoreservice.repository.MerchantRepository;
import com.eshop.eshopcoreservice.service.MerchantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    private MerchantMapper mapper;

    @Override
    public MerchantStoreDto createMerchant(MerchantStoreDto merchantDto) {
        MerchantStoreEntity merchantStore = merchantRepository.save(mapper.convertToEntity(merchantDto));
        return mapper.convertToDto(merchantStore);
    }

    @Override
    public List<MerchantStoreDto> getMerchantList() {
        List<MerchantStoreEntity> listOfMerchant = merchantRepository.findByDeletedFalse();
        return listOfMerchant.stream().map((store) -> mapper.convertToDto(store)).collect(Collectors.toList());
    }

    @Override
    public MerchantStoreDto getMerchantById(long id) {
        MerchantStoreEntity merchantStore = merchantRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Merchant was not found in given id"));
        return mapper.convertToDto(merchantStore);
    }

    @Override
    public MerchantStoreDto updateMerchant(long id, MerchantStoreDto merchantStore) {
        MerchantStoreEntity toUpdate = merchantRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Merchant was not found in given id"));

        MerchantStoreEntity updatedMerchant = merchantRepository.save(mapper.convertToEntity(merchantStore));

        return mapper.convertToDto(updatedMerchant);
    }

    @Override
    public void deleteMerchant(long id) {
        MerchantStoreEntity merchantStore = merchantRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Merchant was not found in given id"));

        merchantStore.setDeleted(true);

        merchantRepository.save(merchantStore);
    }
}
