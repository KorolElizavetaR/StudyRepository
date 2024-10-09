package com.mockito.junit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "category")
@Data
public class Category {
	@Id
    @Column(name = "category_name")
    @NotBlank(message = "Category name is required")
    @Size(max = 15, message = "Category name cannot be more than 15 characters")
    private String category;

	@Column(name = "description")
    private String description;
}
