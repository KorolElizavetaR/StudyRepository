package com.mockito.junit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mockito.junit.exception.ProductNotFoundException;
import com.mockito.junit.model.Product;
import com.mockito.junit.repository.ProductRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional (readOnly = true)
public class ProductService {
	private final ProductRepository productRepository;

	@Transactional (readOnly = false)
	public Product saveProduct(@Valid Product product) {
		return productRepository.save(product);
	}

	// Get all products
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// Get product by ID
	public Product getProductById(int productId) {
		return productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException());
	}

	// Get products by name containing a specific string
	public List<Product> getProductsByName(String productName) {
		return productRepository.findByProductNameContaining(productName);
	}

	@Transactional (readOnly = false)
	public void deleteProduct(int productId) {
		Product product = productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException());
		productRepository.delete(product);
	}
	
	@Transactional (readOnly = false)
	public Product updateProduct(@Valid Product newProduct, int productId) {
		Product product = productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException());
		newProduct.setId(productId);
		return productRepository.save(newProduct);
	}
}