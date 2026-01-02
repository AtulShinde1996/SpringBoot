package com.example.demo.exceptionHandling;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApiException{

	public UnauthorizedException(String message, HttpStatus status) {
		super(message, HttpStatus.UNAUTHORIZED);
		// TODO Auto-generated constructor stub
	}

	

}
