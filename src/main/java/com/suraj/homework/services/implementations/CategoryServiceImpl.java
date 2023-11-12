package com.suraj.homework.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.suraj.homework.dtos.GenericCategoryDto;
import com.suraj.homework.models.Category;
import com.suraj.homework.repositories.CategoryRepository;
import com.suraj.homework.services.CategoryService;

@Service
@Primary
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        super();
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Category addCategory(GenericCategoryDto categoryDto) {
        return categoryRepository.save(modelMapper.map(categoryDto, Category.class));
    }
    
}
