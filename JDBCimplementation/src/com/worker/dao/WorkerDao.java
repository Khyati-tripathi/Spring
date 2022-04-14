package com.worker.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.worker.model.Worker;

public interface WorkerDao {
	public int add(Worker worker) throws SQLException;

	public void delete(int workerId) throws SQLException;

	public Worker getWorker(int workerId) throws SQLException;

	public List<Worker> getWorkers() throws SQLException;

	public void update(Worker worker) throws SQLException;

	public void setDataSource(DataSource dataSource);
}
