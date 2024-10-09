package com.mockito.junit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Order")
@NoArgsConstructor
public class OrderNotFoundException extends RuntimeException {
	
	OrderNotFoundException(String msg) {
		super(msg);
	}
	
}
