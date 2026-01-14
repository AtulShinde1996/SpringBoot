package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.annotaionbasedbean.Employee;
import com.example.demo.annotaionbasedbean.EmployeeService;

import jakarta.annotation.PostConstruct;



@SpringBootApplication
public class SpringCoreDemoApplication {

	@Autowired
	 EmployeeService empService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDemoApplication.class, args);
		
	}

	@PostConstruct
	public  void dispaly() {
		Employee newEmployee = empService.createNewEmployee();
		System.out.println(newEmployee.getName());
	}
	
}
