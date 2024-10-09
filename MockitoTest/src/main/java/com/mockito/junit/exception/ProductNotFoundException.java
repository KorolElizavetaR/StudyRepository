package com.mockito.junit.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductNotFoundException extends RuntimeException {

	ProductNotFoundException(String msg) {
		super(msg);
	}

}
