package com.webapp.techshop.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name = "products")
@NoArgsConstructor
public class Product {
	@Id
	@Column (name = "product_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotNull
	private String title;
	
	@Column
	private String description;
	
	@Column
	@NotNull
	private BigDecimal price;
	
	@Column
	private String city;
	
	@Column
	private String author;

	public Product(String title, BigDecimal price) {
		this.title = title;
		this.price = price;
	}

	public Product(String title, String description, BigDecimal price, String city, String author) {
		this(title, price);
		this.description = description;
		this.city = city;
		this.author = author;
	}
	
}
