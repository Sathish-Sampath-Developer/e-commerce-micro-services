package com.eshop.eshopcustomerservice.controller;

import com.eshop.eshopcustomerservice.dto.ProductDto;
import com.eshop.eshopcustomerservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/products")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return new ResponseEntity<>(productService.getListOfProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
}
