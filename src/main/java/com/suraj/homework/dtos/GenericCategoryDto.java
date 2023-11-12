package com.suraj.homework.dtos;

import java.util.List;
import java.util.UUID;

import com.suraj.homework.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericCategoryDto {
    private UUID id;
    private String name;
    // private List<Product> products;
}
