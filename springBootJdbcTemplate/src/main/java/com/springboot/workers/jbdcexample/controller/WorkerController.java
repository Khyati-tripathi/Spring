package com.springboot.workers.jbdcexample.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.jbdcexample.model.Worker;
import com.springboot.workers.jbdcexample.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepository workerRepository;

	@GetMapping("/showWorker")
	public Worker showWorker() {
		return workerRepository.getWorkerById(1);

	}

	@GetMapping("/all/showWorker")
	public List<Worker> showAllWorker() {
		return workerRepository.getAllWorkers();

	}

	@GetMapping("/create")
	public void createWorker() {
		workerRepository.create(107, "KHYATI", "T", 203456, new java.sql.Date(new Date().getTime()), "HR",
				"K.T@my_org.com");

	}

	@GetMapping("/update")
	public void updateWorker() {
		workerRepository.update(107);

	}

	@GetMapping("/delete")
	public void deleteWorker() {
		workerRepository.delete(9);

	}
}