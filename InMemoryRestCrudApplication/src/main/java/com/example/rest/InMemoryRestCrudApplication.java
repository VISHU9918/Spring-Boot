package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InMemoryRestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(InMemoryRestCrudApplication.class, args);
		System.out.println("REST API");
	}

}
