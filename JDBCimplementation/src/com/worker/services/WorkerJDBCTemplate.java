package com.worker.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.worker.dao.WorkerDao;
import com.worker.mappers.WorkerMapper;
import com.worker.model.Worker;

public class WorkerJDBCTemplate implements WorkerDao {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int add(Worker w) {
		String sql = "INSERT INTO worker VALUES( ? , ? , ? , ? , ? , ? , ? );";

		jdbcTemplateObject.update(sql, w.getWorkerId(), w.getfirstName(), w.getlastName(), w.getSalary(),
				w.getjoiningDate(), w.getDepartment(), w.getEmail());

		System.out.println("Worker " + w.getfirstName() + "'s record inserted successfully");
		return 1;

	}

	@Override
	public Worker getWorker(int id) {
		String sql = "SELECT * FROM Worker WHERE worker_id = ?";

		return jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new WorkerMapper());
	}

	@Override
	public List<Worker> getWorkers() {
		String sql = "SELECT * FROM Worker";

		return jdbcTemplateObject.query(sql, new WorkerMapper());
	}

	@Override
	public void update(Worker w) {
		String sql = "UPDATE worker SET worker_id = ?,first_name = ? ,last_name = ? ,salary = ?,	joining_date =  ? ,	department = ? ,email = ? WHERE worker_id = ? ";
		jdbcTemplateObject.update(sql, w.getWorkerId(), w.getfirstName(), w.getlastName(), w.getSalary(),
				w.getjoiningDate(), w.getDepartment(), w.getEmail(), w.getWorkerId());
		System.out.println("Record #" + w.getWorkerId() + " updated!");
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Worker WHERE worker_id = ?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Record #" + id + " deleted");
	}

}