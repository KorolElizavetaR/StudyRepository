package com.mockito.junit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "product")
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "product_id")
	private int id;

	@NotBlank(message = "Product name is required")
	@Size(max = 50, message = "Product name cannot exceed 50 characters")
	@Column (name = "product_name")
	private String productName;

	@ManyToOne
	@JoinColumn(name = "category_name", referencedColumnName = "category_name", nullable = true)
	private Category category;

	@NotNull(message = "Unit price is required")
	@Min(value = 0, message = "Unit price must be positive")
	@Column (name = "unit_price")
	private double unitPrice;

	@NotNull(message = "Units in stock is required")
	@Min(value = 0, message = "Units in stock must be non-negative")
	@Column (name = "units_in_stock")
	private int unitsInStock;
}
