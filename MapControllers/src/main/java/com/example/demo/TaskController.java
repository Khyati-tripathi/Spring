package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	@GetMapping("/task")
	public String task() {
		return "Task demonstration";
	}

	@GetMapping("/task/showMyInfo")
	public String showMyInfo() {
		return "Name: Khyati Tripathi, City: Lucknow, State: Uttar Pradesh, Dream_Job: Software Developer";
	}

	@GetMapping("task/showMyHobbies")
	public List<String> showMyHobbies() {
		return List.of("Travelling", "Netflix", "painting");
	}
}
