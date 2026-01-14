package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserDetails {

	@GetMapping("/details")
	public ResponseEntity<Map<String, String>> getUserList(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("Atul", "Backend Developer+DevOps+Cloud");
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
	}
}
