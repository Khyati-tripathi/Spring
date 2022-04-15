package com.springboot.workers.jbdcexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.jbdcexample.util.DateTimeUtilities;

@RestController
public class HomeController {
	@GetMapping("/")
	public String welcomeMsg() {

		return "Hello visitor!\n Visiting time: " + DateTimeUtilities.getCurrentTimestamp();
	}

}