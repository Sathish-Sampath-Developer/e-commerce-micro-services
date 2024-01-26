package com.eshop.eshopcoreservice.service;

import com.eshop.eshopcoreservice.dto.ProductDto;
import com.eshop.eshopcoreservice.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto product);
    List<ProductDto> getProductList();
    ProductDto getProductById(long id);
    ProductDto updateProduct(long  id, ProductDto product);
    void deleteProduct(long id);
}
