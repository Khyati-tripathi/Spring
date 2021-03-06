package com.springboot.workers.crudapi.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.util.DatabaseConnection;

@Repository
public class WorkerRepository implements WorkerDAO {
	private final Connection con;

	public WorkerRepository() throws Exception {
		this.con = DatabaseConnection.getConnection();
	}

	@Override
	public int insertWorker(Worker worker) throws SQLException {
		String format = "insert into worker values (?,?,?,?,?,?,?)";

		try (PreparedStatement ps = con.prepareStatement(format)) {
			ps.setInt(1, worker.getWorkerId());
			ps.setString(2, worker.getFirstName());
			ps.setString(3, worker.getLastName());
			ps.setInt(4, worker.getSalary());
			ps.setDate(5, worker.getJoiningDate());
			ps.setString(6, worker.getDepartment());
			ps.setString(7, worker.getEmail());

			int col = ps.executeUpdate();
			System.out.println(con + " row added");
			return col;
		}
	}

	@Override
	public void deleteWorkerById(int workerId) throws SQLException {
		String del = String.format("delete from worker where worker_id='%d'", workerId);
		try (Statement state = con.createStatement()) {
			int rowDeleted = state.executeUpdate(del);
			System.out.println(rowDeleted + " row deleted");
		}
	}

	@Override
	public Worker findWorkerById(int workerId) throws SQLException {
		String get = String.format("select * from worker where worker_id='%d'", workerId);
		Worker worker = null;
		try (Statement state = con.createStatement()) {
			ResultSet result = state.executeQuery(get);
			while (result.next()) {
				int id = result.getInt(1);
				String fName = result.getString(2);
				String lName = result.getString(3);
				int salary = result.getInt(4);
				Date jDate = result.getDate(5);
				String dept = result.getString(6);
				String email = result.getString(7);
				worker = new Worker(id, fName, lName, salary, jDate, dept, email);
			}
		}
		return worker;
	}

	@Override
	public List<Worker> findAllWorkers() throws SQLException {
		List<Worker> workers = new ArrayList<>();

		try (Statement state = con.createStatement()) {
			ResultSet res = state.executeQuery("select * from worker");
			while (res.next()) {
				int id = res.getInt(1);
				String fName = res.getString(2);
				String lName = res.getString(3);
				int salary = res.getInt(4);
				Date jDate = res.getDate(5);
				String dept = res.getString(6);
				String email = res.getString(7);
				workers.add(new Worker(id, fName, lName, salary, jDate, dept, email));
			}
		}
		return workers;
	}

	@Override
	public void replaceWorker(Worker worker) throws SQLException {
		String update = "update worker set first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
		try (PreparedStatement prep = con.prepareStatement(update)) {
			prep.setString(1, worker.getFirstName());
			prep.setString(2, worker.getLastName());
			prep.setInt(3, worker.getSalary());
			prep.setDate(4, worker.getJoiningDate());
			prep.setString(5, worker.getDepartment());
			prep.setString(6, worker.getEmail());
			prep.setInt(7, worker.getWorkerId());

			int rowCount = prep.executeUpdate();
			System.out.println(rowCount + " row updated");
		}
	}

	@Override
	public boolean updateWorkerEmailById(int workerId, String email) throws SQLException {
		String update = "update worker set email=? where worker_id=?";

		PreparedStatement prep = con.prepareStatement(update);
		prep.setString(1, email);
		prep.setInt(2, workerId);

		int rowCount = prep.executeUpdate();

		return rowCount == 1;

	}
}
