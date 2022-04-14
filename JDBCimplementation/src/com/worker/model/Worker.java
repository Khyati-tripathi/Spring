package com.worker.model;

import java.sql.Date;

public class Worker implements Comparable<Worker> {
	private int WorkerId;
	private String firstName;
	private String lastName;
	private int salary;
	private Date joiningDate;
	private String department;
	private String email;

	public Worker() {

	}

	public Worker(int WorkerId, String firstName, String email) {
		this.WorkerId = WorkerId;
		this.firstName = firstName;
		this.email = email;
	}

	public Worker(int WorkerId, String firstName, String email, Date joiningDate) {
		this.WorkerId = WorkerId;
		this.firstName = firstName;
		this.email = email;
		this.joiningDate = joiningDate;
	}

	public Worker(int WorkerId, String firstName, String lastName, int salary, String department, String email) {
		this.WorkerId = WorkerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
		this.email = email;
	}

	public Worker(int WorkerId, String firstName, String lastName, int salary, Date joiningDate, String department,
			String email) {
		this.WorkerId = WorkerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.department = department;
		this.email = email;
	}

	public int getWorkerId() {
		return WorkerId;
	}

	public void setWorkerId(int WorkerId) {
		this.WorkerId = WorkerId;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getjoiningDate() {
		return joiningDate;
	}

	public void setjoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + WorkerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (WorkerId != other.WorkerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Worker [department=" + department + ", email=" + email + ", firstName=" + firstName + ", joiningDate="
				+ joiningDate + ", lastName=" + lastName + ", salary=" + salary + ", WorkerId=" + WorkerId + "]";
	}

	@Override
	public int compareTo(Worker w) {
		return this.getWorkerId() - w.getWorkerId();

	}

}
