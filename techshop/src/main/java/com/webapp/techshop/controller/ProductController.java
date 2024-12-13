package com.webapp.techshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.techshop.model.Product;
import com.webapp.techshop.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping ("/products")
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping("")
	public String getAllProducts(Model model)
	{
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "products/allproducts";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable ("id") Integer id)
	{
		Optional<Product> product = productService.getProductById(id); 
		if (product.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(product.get());
	}
	
	@PostMapping ("/add")
	public ResponseEntity<Object> addProduct(@RequestBody @Valid Product product, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}
		productService.addProduct(product); 
		return ResponseEntity.ok(product);
	}
	
	@PatchMapping ("/{id}")
	public ResponseEntity<Object> patchStudent(@PathVariable ("id") Integer id, @RequestBody @Valid Product product, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}
		productService.patchProduct(product, id); 
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable ("id") Integer id)
	{
		if (!productService.DeleteProduct(id))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok("Product succesfully deleted");
	}
}
