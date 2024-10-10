package com.mockito.junit.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import com.mockito.junit.model.Product;
import com.mockito.junit.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest 
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductServiceTest {
	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductService productService;
	
	@Test
	public void createProduct_positive()
	{
		Product product = Product.builder().
				unitPrice(20.33).
				unitsInStock(-20).
				build();
			
		when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
		
		Product savedProduct = productService.saveProduct(product);
		
		Assertions.assertThat(savedProduct).isNotNull();
	}
	
	@Test
	public void getByIdTest_positive()
	{
		Product product = Product.builder().
				productName("Chips").
				unitPrice(20.33).
				unitsInStock(20).
				build();
		
		Mockito.doReturn(Optional.of(new Product())).
			when(productRepository).findById(Mockito.anyInt());
		
		//when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(product));
		 
		Product findProduct = productService.saveProduct(product);
		
		Assertions.assertThat(findProduct).isNull();
		//System.out.println("Product: " + findProduct);
	}
	
	@Test
	public void update_positive()
	{
		Product newProduct = Product.builder().
				productName("Milk").
				unitPrice(20.33).
				unitsInStock(20).
				build();
		
		when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(newProduct));
		when(productRepository.save(Mockito.any(Product.class))).thenReturn(newProduct);
		 
		Product updatedProduct = productService.updateProduct(newProduct, 15);
		
		Assertions.assertThat(updatedProduct).isNotNull().as("Product: " + updatedProduct);
		System.out.println("Product: " + updatedProduct);
	}
}
