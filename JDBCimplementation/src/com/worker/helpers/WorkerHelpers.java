package com.worker.helpers;

import java.util.List;

import com.worker.model.Worker;

public class WorkerHelpers {
	public static void printAllWorkers(List<Worker> workers) {
		for (Worker worker : workers) {
			System.out.println("Worker ID: " + worker.getWorkerId());
			System.out.println("First Name: " + worker.getfirstName());
			System.out.println("Last Name: " + worker.getlastName());
			System.out.println("Salary: " + worker.getSalary());
			System.out.println("Joining Date: " + worker.getjoiningDate());
			System.out.println("Department: " + worker.getDepartment());
			System.out.println("Email: " + worker.getEmail());
			System.out.println();
		}
	}
}