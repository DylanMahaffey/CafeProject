package com.revature.models;

public class Customer extends User {
	
	public Customer(String name, String email, String password) {
		super(name, email, password, "customer");
	}

}
