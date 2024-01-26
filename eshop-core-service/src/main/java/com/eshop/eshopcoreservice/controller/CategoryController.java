package com.eshop.eshopcoreservice.controller;

import com.eshop.eshopcoreservice.entity.CategoryEntity;
import com.eshop.eshopcoreservice.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/private/category")
@AllArgsConstructor
@Tag(name = "Category Controller", description = "This url for CRUD of Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity category) {
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getListOfCategory() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getACategory(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable(name = "id") Long id, @RequestBody CategoryEntity category) {
        return new ResponseEntity<>(categoryService.updateCategory(id, category), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
