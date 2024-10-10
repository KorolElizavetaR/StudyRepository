package com.mockito.junit.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CategoryNotFoundException extends RuntimeException {
	
	CategoryNotFoundException(String msg) {
		super(msg);
	}
	
}
