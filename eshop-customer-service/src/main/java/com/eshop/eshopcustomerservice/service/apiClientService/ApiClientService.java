package com.eshop.eshopcustomerservice.service.apiClientService;

import com.eshop.eshopcustomerservice.dto.ManufacturerDto;
import com.eshop.eshopcustomerservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ESHOP-CORE-SERVICE")
public interface ApiClientService {
    @GetMapping("/api/v1/private/products")
    public List<ProductDto> getProducts();

    @GetMapping("/api/v1/private/products/{id}")
    public ProductDto getProductById(@PathVariable(name = "id") long id);
}
