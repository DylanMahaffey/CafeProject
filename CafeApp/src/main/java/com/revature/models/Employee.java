package com.revature.models;

public class Employee extends User {
	
	public Employee(String name, String email, String password) {
		super(name, email, password);
	}
	
	public Employee(int id, String name, String email, String password) {
		super(id, name, email, password);
	}

}
