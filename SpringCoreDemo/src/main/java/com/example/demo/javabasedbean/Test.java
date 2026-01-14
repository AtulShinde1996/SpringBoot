package com.example.demo.javabasedbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.annotaionbasedbean.Employee;

import jakarta.annotation.PostConstruct;
@Component
public class Test {

	 @Autowired
	 Employee employee;
	 
	 @PostConstruct
	 public void displayJavaBasedBaen() {
		 System.out.println(employee.getName());
	 }
	 
}
