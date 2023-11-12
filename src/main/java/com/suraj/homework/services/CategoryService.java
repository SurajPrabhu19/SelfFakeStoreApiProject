package com.suraj.homework.services;

import org.springframework.stereotype.Service;

import com.suraj.homework.dtos.GenericCategoryDto;
import com.suraj.homework.models.Category;

@Service
public interface CategoryService {

    Category addCategory(GenericCategoryDto categoryDto);

    
}
