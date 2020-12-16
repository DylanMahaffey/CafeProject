package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.util.DB_Connection;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer selectCustomerById(int id) {
		List<Customer> customers = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM users WHERE user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
			
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