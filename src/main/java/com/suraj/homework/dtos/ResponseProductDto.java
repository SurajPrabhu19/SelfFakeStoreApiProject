package com.suraj.homework.dtos;

import com.suraj.homework.models.Price;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductDto {
    private String title;
    private String description;
    private Price price;
    private String company;
}
