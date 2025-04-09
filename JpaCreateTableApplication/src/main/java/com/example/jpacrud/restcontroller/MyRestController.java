package com.example.jpacrud.restcontroller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyRestController {
	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello ";
	}

}
