package com.task1;

public class MyBean {
	String firstname;
	String lastname;
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public static MyBean getBeanInstance() {
		return new MyBean();
		
	}
	@Override
	public String toString() {
		return "MyBean [firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
}
