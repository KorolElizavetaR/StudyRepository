package com.webapp.techshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.techshop.model.Product;
import com.webapp.techshop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j // Логирование ??
@Transactional (readOnly = true)
public class ProductService {
	private final ProductRepository productRepository;
	
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	public Optional <Product> getProductById(Integer id)
	{
		return productRepository.findById(id);
	}
	
	@Transactional
	public Product addProduct(Product product)
	{
		log.info("Saving ", product);
		return productRepository.save(product);
	}
	
	@Transactional
	public Product patchProduct(Product product, Integer id)
	{
		product.setId(id);
		return productRepository.save(product);
	}
	
	@Transactional
	public boolean DeleteProduct(Integer id)
	{
		Boolean itemExists = productRepository.existsById(id);
		if (itemExists)
			productRepository.deleteById(id);
		return itemExists;
	}
}
