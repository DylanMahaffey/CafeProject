package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private List<Order> orders;
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		
		orders = new ArrayList<>();
	}
	
	public User(int id, String name, String email, String password) {
		this(name, email, password);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", orders=" + orders + "]";
	}

}
