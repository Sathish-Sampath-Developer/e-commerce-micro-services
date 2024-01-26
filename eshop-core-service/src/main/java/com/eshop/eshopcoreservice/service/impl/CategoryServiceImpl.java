package com.eshop.eshopcoreservice.service.impl;

import com.eshop.eshopcoreservice.entity.CategoryEntity;
import com.eshop.eshopcoreservice.exception.ServiceException;
import com.eshop.eshopcoreservice.repository.CategoryRepository;
import com.eshop.eshopcoreservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findByDeletedFalse();
    }

    @Override
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Category was not found given id"));
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity category) {
        CategoryEntity updatedCategory = categoryRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Category was not found given id"));

        updatedCategory.setCategoryStatus(category.isCategoryStatus());
        updatedCategory.setTitle(category.getTitle());

        return categoryRepository.save(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        CategoryEntity category = categoryRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Category was not found given id"));
        category.setDeleted(true);
        categoryRepository.save(category);
    }
}
