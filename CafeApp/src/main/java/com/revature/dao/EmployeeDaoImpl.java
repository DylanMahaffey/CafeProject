package com.revature.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.models.Employee;
import com.revature.util.DB_Connection;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void insertEmployee(Employee emp) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "INSERT INTO users (name, email, password, type) VALUES "
						+ "(?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getPassword());
			ps.setString(4, "employee");
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee selectEmployeeById(int id) {
		List<Employee> employees = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM users WHERE id = ? AND type = 'employee';";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		Employee employee = null;
		if(employees.size() > 0) {
			employee = employees.get(0);
		}
		return employee;
	}
	
	@Override
	public Employee selectEmployeeByEmail(String email) {
		List<Employee> employees = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM users WHERE email = ? AND type = 'employee';";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		Employee employee = null;
		if(employees.size() > 0) {
			employee = employees.get(0);
		}
		return employee;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM users WHERE type = 'employee';";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void updateEmployee(Employee emp) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "UPDATE users SET (name, email, password) WHERE "
						+ "name = ? AND email = ? AND password = ? AND type = 'employee';"
						+ "(?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getPassword());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(Employee emp) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "DELETE FROM users WHERE "
						+ "name = ? AND email = ? AND password = ? AND type = 'employee';"
						+ "(?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getPassword());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}