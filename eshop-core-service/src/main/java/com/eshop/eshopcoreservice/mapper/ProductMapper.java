package com.eshop.eshopcoreservice.mapper;

import com.eshop.eshopcoreservice.dto.MerchantStoreDto;
import com.eshop.eshopcoreservice.dto.ProductDto;
import com.eshop.eshopcoreservice.entity.MerchantStoreEntity;
import com.eshop.eshopcoreservice.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapper {
    private final ModelMapper mapper;

    public ProductEntity convertToEntity(ProductDto productDto) {
        return mapper.map(productDto, ProductEntity.class);
    }

    public ProductDto convertToDto(ProductEntity product) {
        return mapper.map(product, ProductDto.class);
    }
}
