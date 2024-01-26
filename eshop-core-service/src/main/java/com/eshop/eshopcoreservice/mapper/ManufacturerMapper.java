package com.eshop.eshopcoreservice.mapper;

import com.eshop.eshopcoreservice.dto.ManufacturerDto;
import com.eshop.eshopcoreservice.dto.ProductDto;
import com.eshop.eshopcoreservice.entity.ManufacturerEntity;
import com.eshop.eshopcoreservice.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManufacturerMapper {

    private final ModelMapper mapper;

    public ManufacturerEntity convertToEntity(ManufacturerDto manufacturerDto) {
        return mapper.map(manufacturerDto, ManufacturerEntity.class);
    }

    public ManufacturerDto convertToDto(ManufacturerEntity manufacturerEntity) {
        return mapper.map(manufacturerEntity, ManufacturerDto.class);
    }
}
