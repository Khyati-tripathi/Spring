package com.example.demo;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String welcome() {
		return "<h1>Hello visitor !! </h1>" + new Timestamp(System.currentTimeMillis());
	}

}