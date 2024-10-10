package com.mockito.junit.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mockito.junit.model.Product;
import com.mockito.junit.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RunWith (SpringRunner.class)
@SpringBootTest
class ProductServiceTest2 {
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;

	@Test
	void testSaveProduct() {
		Product product = Product.builder().
				productName("Chips").
				unitPrice(20.33).
				unitsInStock(20).
				build();
		Product savedProduct = productService.saveProduct(product);
		//fail("Not yet implemented");
	}

	@Test
	void testGetProductById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateProduct() {
		fail("Not yet implemented");
	}

}
