package com.springboot.workers.jbdcexample.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.jbdcexample.model.Worker;

public interface WorkerDAO {
	public int add(Worker worker) throws SQLException;

	public void delete(int workerId) throws SQLException;

	public Worker getWorker(int workerId) throws SQLException;

	public List<Worker> getWorkers() throws SQLException;

	public int update(Worker emp) throws SQLException;
}