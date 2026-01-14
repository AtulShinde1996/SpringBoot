package com.example.demo.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonScope {

	public String myName() {
		return "atul";
	}
}
