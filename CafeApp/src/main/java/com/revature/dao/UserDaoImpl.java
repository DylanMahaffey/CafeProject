package com.revature.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.models.User;
import com.revature.util.DB_Connection;

public class UserDaoImpl implements UserDao{

	@Override
	public void insertUser(User c) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "INSERT INTO users (name, email, password) VALUES "
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
	public User selectUserById(int id) {
		List<User> users = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM users WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(new User(rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		User user = null;
		if(users.size() > 0) {
			user = users.get(0);
		}
		return user;
	}
	
	@Override
	public User selectUserByEmail(String email) {
		List<User> users = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM users WHERE email = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			ps.close();
			while(rs.next()) {
				users.add(new User(rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		User user = null;
		if(users.size() > 0) {
			user = users.get(0);
		}
		return user;
	}

	@Override
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM users;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(new User(rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void updateUser(User c) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "UPDATE users SET (name, email, password, type) WHERE "
						+ "name = ? AND email = ? AND password = ?;"
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
	public void deleteUser(User c) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "DELETE FROM users WHERE "
						+ "name = ? AND email = ? AND password = ?;"
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