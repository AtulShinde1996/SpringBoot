package com.example.demo.javabasedbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.annotaionbasedbean.Employee;

@Configuration
public class Demo {

	@Bean
	public Employee employee(){
		Employee e=new Employee();
		e.setName("Mohan Sardar");
		return e;
	}
}
