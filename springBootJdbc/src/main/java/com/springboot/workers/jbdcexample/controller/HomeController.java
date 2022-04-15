package com.springboot.workers.jbdcexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

	@RequestMapping("/")
	public String welcomeMessage() {
		return "Hello visitor!\nVisiting time: " + System.currentTimeMillis();
	}

}
