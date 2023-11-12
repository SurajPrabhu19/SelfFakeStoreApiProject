package com.suraj.homework.dtos;

import java.util.UUID;

import com.suraj.homework.models.Category;
import com.suraj.homework.models.Price;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private UUID id;
    private String title;
    private String description;
    private Price price;
    private String company;
    // private Category category;
}
