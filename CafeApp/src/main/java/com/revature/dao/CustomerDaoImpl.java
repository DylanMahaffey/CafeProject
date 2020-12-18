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
			String sql = "INSERT INTO customers (customer_name, customer_email, customer_password) VALUES "
						+ "(?,?,?)";
			
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
			String sql = "SELECT * FROM customers WHERE customer_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customers.add(new Customer(rs.getInt("customer_id"), rs.getString("customer_name"), rs.getString("customer_email"), rs.getString("customer_password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		Customer customer = null;
		if(customers.size() > 0) {
			customer = customers.get(0);
		}
		return customer;
	}
	
	@Override
	public Customer selectCustomerByEmail(String email) {
		List<Customer> customers = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM customers WHERE customer_email = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customers.add(new Customer(rs.getInt("customer_id"), rs.getString("customer_name"), rs.getString("customer_email"), rs.getString("customer_password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		Customer customer = null;
		if(customers.size() > 0) {
			customer = customers.get(0);
		}
		return customer;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM customers;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customers.add(new Customer(rs.getInt("customer_id"), rs.getString("customer_name"), rs.getString("customer_email"), rs.getString("customer_password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public void updateCustomer(Customer c) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "UPDATE customers SET customer_name = ?, customer_password = ?, customer_email WHERE "
						+ "customer_id = ?;"
						+ "(?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getEmail());
			ps.setInt(4, c.getId());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(Customer c) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "DELETE FROM customers WHERE "
						+ "customer_name = ? AND customer_email = ? AND customer_password = ?;"
						+ "(?,?,?)";
			
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