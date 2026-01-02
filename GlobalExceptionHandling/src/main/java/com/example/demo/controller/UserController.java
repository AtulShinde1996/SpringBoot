package com.example.demo.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionHandling.ResourceNotFoundException;
import com.example.demo.exceptionHandling.UnauthorizedException;
import com.example.demo.model.User;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	MessageSource messageSource;

	@PostMapping("/users")
	public ResponseEntity<User>getDetils(@Valid @RequestBody User user){
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/check")
	public ResponseEntity<Map<String, String>> getDetails(){
		String message = messageSource.getMessage("auth.invalid.credentials", null, Locale.getDefault());
		Map<String, String> map=new HashMap<>();
		map.put("Atul", "Shinde");
		map.put("Max", "Thomus");
		if(map.size()==0) {
//			throw new UnauthorizedException("Invalid user", HttpStatus.UNAUTHORIZED);
			throw new UnauthorizedException(message, HttpStatus.UNAUTHORIZED);
		}else {
			//throw new ResourceNotFoundException("Resource not found", HttpStatus.NOT_FOUND);
			throw new ResourceNotFoundException("Resource not found", HttpStatus.NOT_FOUND);
		}
//		return new ResponseEntity<Map<String,String>>(HttpStatus.OK);
	}
}
