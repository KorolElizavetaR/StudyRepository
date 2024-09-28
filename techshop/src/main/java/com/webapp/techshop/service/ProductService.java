package com.webapp.techshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.techshop.model.Product;
import com.webapp.techshop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
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
		return productRepository.save(product);
	}
	
	@Transactional
	public Product patchProduct(Product product, Integer id)
	{
		product.setId(id);
		return productRepository.save(product);
	}
	
	@Transactional
	public void DeleteProduct(Integer id)
	{
		productRepository.deleteById(id);
	}
}
