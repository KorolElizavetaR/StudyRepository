package com.mockito.junit.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsernameNotFound extends RuntimeException{
	
	public UsernameNotFound(String msg) {
		super(msg);
	}

}
