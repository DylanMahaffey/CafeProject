package com.revature.models;

public class Customer extends User {
	
	public Customer(String name, String email, String password) {
		super(name, email, password);
	}
	
	public Customer(int id, String name, String email, String password) {
		super(id, name, email, password);
	}

}
