package com.springboot.workers.jbdcexample.controller;

import java.sql.SQLException;
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
		try {
			return this.workerRepository.getWorker(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/all/showWorker")
	public List<Worker> showAllWorker() {
		try {
			return this.workerRepository.getWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List.of();

	}

	@GetMapping("/create")
	public String createWorker() {
		int rowsAffected;
		try {
			rowsAffected = this.workerRepository.add(new Worker(111, "khyati", "tri", 45000,
					new java.sql.Date(new Date().getTime()), "Controller", "khyati@gmail.com"));
			return rowsAffected + " rows Affected";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	@GetMapping("/update")
	public String updateWorker() {
		int rowsAffected;
		try {
			rowsAffected = this.workerRepository.update(new Worker(111, "khyati", "tripathi", 75000,
					new java.sql.Date(new Date().getTime()), "IT", "dfgh@gmail.com"));
			return rowsAffected + " rows Affected";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Worker not found";
	}

	@GetMapping("/delete")
	public String deleteWorker() {
		try {
			this.workerRepository.delete(9);
			return "Record deleted";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Record not found";
	}
}
