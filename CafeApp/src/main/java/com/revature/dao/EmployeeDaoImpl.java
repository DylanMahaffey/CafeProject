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
			String sql = "INSERT INTO employees (employee_name, employee_email, employee_password, employee_position, reports_to) VALUES "
						+ "(?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getPassword());
			ps.setString(4, emp.getPosition());
			ps.setInt(5, emp.getReportsTo());
			
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
			String sql = "SELECT * FROM employees WHERE employee_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getInt("employee_id"), rs.getString("employee_name"), rs.getString("employee_email"), rs.getString("employee_password"), 
						rs.getString("employee_position"), rs.getInt("reports_to")));
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
		Employee e = null;
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM employees WHERE employee_email = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getInt("employee_id"), rs.getString("employee_name"), rs.getString("employee_email"), rs.getString("employee_password"), 
						rs.getString("employee_position"), rs.getInt("reports_to")));
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
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
			String sql = "SELECT * FROM employees;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getInt("employee_id"), rs.getString("employee_name"), rs.getString("employee_email"), rs.getString("employee_password"), 
						rs.getString("employee_position"), rs.getInt("reports_to")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void updateEmployee(Employee emp) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "UPDATE employees SET employee_name = ?, employee_email = ?, employee_password = ?, employee_position = ?, reports_to = ? WHERE "
						+ "employee_id = ?;"
						+ "(?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getPassword());
			ps.setString(4,  emp.getPosition());
			ps.setInt(5,  emp.getReportsTo());
			ps.setInt(6, emp.getId());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(Employee emp) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "DELETE FROM employees WHERE "
						+ "employee_name = ? AND employee_email = ? AND employee_password = ?;"
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