package com.suraj.homework.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.suraj.homework.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>{
}
