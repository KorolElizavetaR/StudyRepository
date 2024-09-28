package com.webapp.techshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.techshop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
