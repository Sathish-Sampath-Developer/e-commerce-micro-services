package com.eshop.eshopcustomerservice.service.impl;

import com.eshop.eshopcustomerservice.dto.ProductDto;
import com.eshop.eshopcustomerservice.service.ProductService;
import com.eshop.eshopcustomerservice.service.apiClientService.ApiClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ApiClientService apiClientService;

    @Override
    public List<ProductDto> getListOfProducts() {
        return apiClientService.getProducts();
    }

    @Override
    public ProductDto getProductById(Long id) {
        return apiClientService.getProductById(id);
    }

}
