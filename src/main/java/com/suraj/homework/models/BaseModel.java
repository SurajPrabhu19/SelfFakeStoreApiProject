package com.suraj.homework.models;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.NonNull;

@MappedSuperclass
public class BaseModel {
    @Id
    @NonNull
    // @GeneratedValue(strategy = GenerationType.IDENTITYX)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
}
