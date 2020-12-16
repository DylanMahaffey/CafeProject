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
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "INSERT INTO users (name, email, password) values"
						+ "(?,?,?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPassword());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer selectCustomerById(int id) {
		List<Customer> customers = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customers.add(new Customer(rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customers.get(0);
	}

	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM users WHERE type = 'customer'";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customers.add(new Customer(rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public void updateCustomer(Customer c) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "UPDATE users SET (name, email, password) WHERE "
						+ "name = ? AND email = ? AND password = ?"
						+ "(?,?,?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPassword());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(Customer c) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "DELETE FROM users WHERE "
						+ "name = ? AND email = ? AND password = ?"
						+ "(?,?,?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPassword());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}