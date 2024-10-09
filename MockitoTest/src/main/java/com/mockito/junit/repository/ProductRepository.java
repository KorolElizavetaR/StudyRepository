package com.mockito.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockito.junit.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByProductNameContaining(String productName);
}