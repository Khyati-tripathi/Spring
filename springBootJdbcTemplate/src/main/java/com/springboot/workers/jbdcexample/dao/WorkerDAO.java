package com.springboot.workers.jbdcexample.dao;

import java.sql.Date;
import java.util.List;

import com.springboot.workers.jbdcexample.model.Worker;

public interface WorkerDAO {

	public void create(int worker_id, String first_name, String last_name, int salary, Date joining_date,
			String department, String email);

	public Worker getWorkerById(Integer id);

	public List<Worker> getAllWorkers();

	public void update(int worker_id);

	public void delete(int id);

}