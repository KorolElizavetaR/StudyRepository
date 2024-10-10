package com.mockito.junit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mockito.junit.exception.CategoryNotFoundException;
import com.mockito.junit.model.Category;
import com.mockito.junit.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional (readOnly = true)
public class CategoryService {
	private final CategoryRepository categoryRepository;

	// Save or update category
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	// Get all categories
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	// Get category by name
	public Category getCategoryByID(String ID) {
		return categoryRepository.findById(ID).orElseThrow(()->new CategoryNotFoundException());
	}

	// Delete category by name
	public void deleteCategory(String categoryName) {
		categoryRepository.deleteById(categoryName);
	}
}
