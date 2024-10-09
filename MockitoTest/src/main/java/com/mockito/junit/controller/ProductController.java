package com.mockito.junit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mockito.junit.model.Product;
import com.mockito.junit.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/products")
public class ProductController {
	private final ProductService productService;

    @PostMapping ("/add")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product, BindingResult result) {
    	if (result.hasErrors())
    	{
    		return ResponseEntity.badRequest().build();
    	}
    	return ResponseEntity.ok(productService.saveProduct(product));
    }

    @GetMapping
    public ResponseEntity <List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Product> getProductById(@PathVariable ("id") int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Company is succesfully deleted");
    }
	
}
