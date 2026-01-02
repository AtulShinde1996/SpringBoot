package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	
	@PostMapping("/newUser")
	public ResponseEntity<?> newUserSave(@RequestBody User user ){
		if(user==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		User newUser=new User();
		newUser.setUserName("Max");
		newUser.setEmail("max@gmail.com");
		if(newUser!=null) {
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
		}
		return ResponseEntity.noContent().build();
	}
	
}
