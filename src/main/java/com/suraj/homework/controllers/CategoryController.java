package com.suraj.homework.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.homework.dtos.GenericCategoryDto;
import com.suraj.homework.models.Category;
import com.suraj.homework.models.Product;
import com.suraj.homework.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // public CategoryController(CategoryService categoryService) {
    //     super();
    //     this.categoryService = categoryService;
    // }

    // GET REQUEST: ---------------------------------------

    @GetMapping
    public ResponseEntity<GenericCategoryDto> getAllCategory() {
    // public String getAllCategory() {
        // return "Categoriesss";
        return null;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<List<Product>> getMethodName(@PathVariable UUID id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody GenericCategoryDto categoryDto)
    {
        return new ResponseEntity<Category>(categoryService.addCategory(categoryDto), HttpStatus.OK);
    }

}
