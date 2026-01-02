package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User {

	   @NotBlank(message = "{validation.name.notblank}")
	    private String name;
	   
	   @NotBlank(message = "{validation.email.notblank}")
	   @Email(message = "{validation.email.invalid}")
	    private String email;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@NotBlank String name, @Email String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}

    
    
	
	
}
