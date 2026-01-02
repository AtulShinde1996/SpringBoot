package com.example.demo.exceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Product {

	@GetMapping("/products/{id}")
	public ResponseEntity<?>productDetails(@PathVariable Integer id) throws ProductNotFoundException{
		if(id==null || id==0) {
			throw new ProductNotFoundException("Product is not found on id:-"+id);
		}
		return ResponseEntity.status(HttpStatus.OK).body("product");
	}
	

	@PostMapping("/calculate/{number}")
	public ResponseEntity<Object> calcualtion(@PathVariable Integer number){
		if(number<0) {
			throw new IllegalArgumentException("Invalid number.");
			}
		return new ResponseEntity<Object>(number,HttpStatus.OK);
	}
}
