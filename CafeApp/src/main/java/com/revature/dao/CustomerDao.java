package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.User;

public interface CustomerDao {
	
	//CREATE
	public void insertCustomer(Customer c);
	
	//READ
	public Customer selectCustomerById(int i);
	public List<Customer> selectAllCustomers();
	public Customer selectCustomerByEmail(String email);
	
	//UPDATE
	public void updateCustomer(Customer c);
	
	//DELETE
	public void deleteCustomer(Customer c);



}
