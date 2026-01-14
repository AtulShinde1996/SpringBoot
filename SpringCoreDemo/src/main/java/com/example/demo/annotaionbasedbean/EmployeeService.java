package com.example.demo.annotaionbasedbean;

import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	public Employee createNewEmployee() {
		Employee e=new Employee();
		e.setName("Atul");
		return e;
	}
}
