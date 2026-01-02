package com.example.demo.exceptionHandling;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

	public ResourceNotFoundException(String message, HttpStatus status) {
		super(message, HttpStatus.NOT_FOUND);
		// TODO Auto-generated constructor stub
	}

	

}
