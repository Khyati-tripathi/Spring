package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Worker;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	Worker emp = new Worker(9, "khyati", "tripathi", 50000, new Date(), "new", "k.tripathir@myorg.in");

	@GetMapping("/showWorker")
	public Worker task() {

		return emp;
	}

	@GetMapping("/all/showWorkers")
	public List<Worker> showHobbies() {
		return List.of(emp);
	}
}
