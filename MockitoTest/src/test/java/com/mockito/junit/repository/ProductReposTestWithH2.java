package com.mockito.junit.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mockito.junit.model.Category;
import com.mockito.junit.model.Product;
import com.mockito.junit.service.CategoryService;

import jakarta.validation.ValidationException;

@DataJpaTest
@AutoConfigureTestDatabase (connection = EmbeddedDatabaseConnection.H2)
public class ProductReposTestWithH2 {
	@Autowired
	private ProductRepository productRepository;
	
	@Test //(expected = jakarta.validation.ConstraintViolationException.class)
	public void ProductRepository_Save_ReturnSavedProduct()
	{
		// arrange
		Product product = Product.builder().
				productName("Cake").
				unitPrice(20.33).
				unitsInStock(20).
				build();
		// act
		Product savedProduct = productRepository.save(product);
		// assert
		Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);	
	}
	
	@Test
	public void ProductRepository_SaveThrows()
	{
		Product product = Product.builder().
				productName("Coke").
				unitPrice(20.33).
				unitsInStock(-20).
				build();
		// act
		// assert
		assertThrows(ValidationException.class, () -> productRepository.save(product));	
	}
}
