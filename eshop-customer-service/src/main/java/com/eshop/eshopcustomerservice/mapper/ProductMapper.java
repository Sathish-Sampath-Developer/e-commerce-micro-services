package com.eshop.eshopcustomerservice.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class ProductMapper {
    @Autowired
    private ModelMapper mapper;
}
