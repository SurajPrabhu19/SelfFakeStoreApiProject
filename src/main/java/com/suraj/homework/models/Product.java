package com.suraj.homework.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product extends BaseModel {
    @NonNull
    private String title;

    private String description;

    @JoinColumn(nullable = false)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Price price;

    private String company;

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE})
    @JoinColumn(nullable = false)
    private Category category;

    private String manufacturedDate;
}
