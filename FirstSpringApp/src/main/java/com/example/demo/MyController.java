package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MyController {
	public String sayHi() {
		return "index";
	}
	@ResponseBody
	@GetMapping("/hi")
	public String sayHello() {
		return "Hello Namaskara";
	}

}
