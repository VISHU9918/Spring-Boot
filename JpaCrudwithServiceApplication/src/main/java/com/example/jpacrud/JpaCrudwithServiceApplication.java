package com.example.jpacrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaCrudwithServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCrudwithServiceApplication.class, args);
		System.out.println("Service");
	}

}
