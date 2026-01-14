package com.example.demo.scope;

import com.example.demo.javabasedbean.Demo;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component	
public class ScopeTest {

    
  private final SingletonScope singleton;

  @Autowired
  public ScopeTest(SingletonScope singleton, Demo demo) {
		this.singleton = singleton;
		
  }
	@PostConstruct
  public void testSingletonScope() {
	  String myName = singleton.myName();
	  System.out.println(myName);
  }
}
