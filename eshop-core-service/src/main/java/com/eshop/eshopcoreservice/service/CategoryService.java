package com.eshop.eshopcoreservice.service;

import com.eshop.eshopcoreservice.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();
    CategoryEntity getCategoryById(Long id);
    CategoryEntity saveCategory(CategoryEntity category);
    CategoryEntity updateCategory(Long id, CategoryEntity category);
    void deleteCategory(Long id);
}
