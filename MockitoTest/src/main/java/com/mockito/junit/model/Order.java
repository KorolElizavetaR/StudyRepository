package com.mockito.junit.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order")
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "order_id")
	private int orderId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column (name = "ordered_at")
	private LocalDateTime orderedAt = LocalDateTime.now();

	@Min(value = 1, message = "Quantity must be greater than 0")
	@Column (name = "quantity")
	private int quantity;
}
