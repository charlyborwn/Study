package com.home.springboot.restWs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping("/")
	public String home() {
		
		return "Hello World";
	}
	
	
}