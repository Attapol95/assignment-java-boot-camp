package com.java.assignment1.repository;

import com.java.assignment1.modle.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findByNameContains(String productName);
    Optional<ProductEntity> findById(String productId);
}