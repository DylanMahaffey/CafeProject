package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	
	//CREATE
	void insertEmployee(Employee e);
	
	//READ
	public Employee selectEmployeeById(int i);
	public List<Employee> selectAllEmployees();
	
	//UPDATE
	public void updateEmployee(Employee e);
	
	//DELETE
	public void deleteEmployee(Employee e);

}
