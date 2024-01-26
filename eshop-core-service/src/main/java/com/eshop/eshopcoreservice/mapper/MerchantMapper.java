package com.eshop.eshopcoreservice.mapper;

import com.eshop.eshopcoreservice.dto.MerchantStoreDto;
import com.eshop.eshopcoreservice.entity.MerchantStoreEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MerchantMapper {

    private final ModelMapper mapper;

    public MerchantMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public MerchantStoreEntity convertToEntity(MerchantStoreDto merchantStoreDto) {
        return mapper.map(merchantStoreDto, MerchantStoreEntity.class);
    }

    public MerchantStoreDto convertToDto(MerchantStoreEntity merchantStore){
        return mapper.map(merchantStore,MerchantStoreDto.class);
    }
}
