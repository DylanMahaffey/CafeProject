package com.revature.models;

public class Employee extends User {
	
	private String position;
	private int reportsTo;
	
	public Employee(String name, String email, String password) {
		super(name, email, password);
	}
	
	public Employee(int id, String name, String email, String password, String position, int reoprtsTo) {
		super(id, name, email, password);
		this.position = position;
		this.reportsTo = reportsTo;
	}

	public String getPosition() {
		return position;
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	@Override
	public String toString() {
		return "Employee [name= "+ this.getName() +", email="+ this.getName() +", position=" + position + ", reportsTo=" + reportsTo + "]";
	}
	
	

}
