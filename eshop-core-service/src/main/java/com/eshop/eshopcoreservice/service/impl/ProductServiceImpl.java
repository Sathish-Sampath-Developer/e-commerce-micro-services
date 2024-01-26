package com.eshop.eshopcoreservice.service.impl;

import com.eshop.eshopcoreservice.dto.ProductDto;
import com.eshop.eshopcoreservice.entity.ManufacturerEntity;
import com.eshop.eshopcoreservice.entity.ProductEntity;
import com.eshop.eshopcoreservice.exception.ServiceException;
import com.eshop.eshopcoreservice.mapper.ManufacturerMapper;
import com.eshop.eshopcoreservice.mapper.ProductMapper;
import com.eshop.eshopcoreservice.repository.ManufacturerRepository;
import com.eshop.eshopcoreservice.repository.ProductRepository;
import com.eshop.eshopcoreservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    private ProductMapper productMapper;
    private ManufacturerMapper manufacturerMapper;

    @Override
    public ProductDto createProduct(ProductDto product) {
        ManufacturerEntity manufacturer = manufacturerRepository.findByIdAndDeletedFalse(product.getManufacturer().getId()).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Manufacturer was not found given id!."));


        product.setManufacturer(manufacturerMapper.convertToDto(manufacturer));

        ProductEntity newProduct = productMapper.convertToEntity(product);

        return productMapper.convertToDto(productRepository.save(newProduct));
    }

    @Override
    public List<ProductDto> getProductList() {
        List<ProductEntity> listOfTheProducts = productRepository.findByDeletedFalse();

        return listOfTheProducts.stream().map((product) -> productMapper.convertToDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(long id) {
        ProductEntity product = productRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Product was not found given id!."));
        return productMapper.convertToDto(product);
    }

    @Override
    public ProductDto updateProduct(long id, ProductDto productDto) {
        ProductEntity toUpdate = productRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Product was not found given id!."));

        ManufacturerEntity manufacturer = manufacturerRepository.findByIdAndDeletedFalse(productDto.getManufacturer().getId()).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Manufacturer was not found given id!."));

        toUpdate.setProduct_images(productDto.getProduct_images());
        toUpdate.setProductQuantity(productDto.getProductQuantity());
        toUpdate.setProductDateAvailable(productDto.getProductDateAvailable());
        toUpdate.setAvailable(productDto.getAvailable());
        toUpdate.setCategories(productDto.getCategories());
        toUpdate.setDescription(productDto.getDescription());
        toUpdate.setPrice(productDto.getPrice());
        toUpdate.setProductQuantityOrderMax(productDto.getProductQuantityOrderMax());
        toUpdate.setProductQuantityOrderMin(productDto.getProductQuantityOrderMin());
        toUpdate.setRegion(productDto.getRegion());
        toUpdate.setSku(productDto.getSku());
        toUpdate.setThumbnail(productDto.getThumbnail());
        toUpdate.setTitle(productDto.getTitle());
        toUpdate.setManufacturer(manufacturer);

        ProductEntity updatedProduct = productRepository.save((toUpdate));

        return productMapper.convertToDto(updatedProduct);
    }

    @Override
    public void deleteProduct(long id) {
        ProductEntity product = productRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Product was not found given id!."));
        product.setDeleted(true);
        productRepository.save(product);
    }
}
