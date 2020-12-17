package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDao {
	
	//CREATE
	public void insertCustomer(Customer c);
	
	//READ
	public Customer selectCustomerById(int i);
	public Customer selectCustomerByEmail(String e);
	public List<Customer> selectAllCustomers();
	
	//UPDATE
	public void updateCustomer(Customer c);
	
	//DELETE
	public void deleteCustomer(Customer c);



}
