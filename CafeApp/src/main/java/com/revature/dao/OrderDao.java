package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface OrderDao {
	
	//CREATE
	public void insertCustomer(Customer c);
	
	//READ
	public Customer selectCustomerById(int id);
	public List<Customer> selectAllCustomers();
	
	//UPDATE
	public void updateCustomer(Customer c);
	
	//DELETE
	public void deleteCustomer(Customer c);

}
