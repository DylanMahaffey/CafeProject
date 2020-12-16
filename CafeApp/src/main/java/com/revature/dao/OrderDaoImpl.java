package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Customer;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer selectCustomerById(int id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * from "
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

}
