package com.eshop.eshopcustomerservice.service;

import com.eshop.eshopcustomerservice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getListOfProducts();

    ProductDto getProductById(Long id);
}
