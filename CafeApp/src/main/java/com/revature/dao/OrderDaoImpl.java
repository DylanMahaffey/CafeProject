package com.revature.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Order;
import com.revature.util.DB_Connection;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void insertOrder(Order o) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "INSERT INTO orders (foodordered, user_id) VALUES "
						+ "(?,?)";

			Array foodArray = conn.createArrayOf("_text", o.getFoodOrdered().toArray());
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, o.getUserId());
			ps.setArray(2, foodArray);
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Order selectOrderByOrderNumber(long orderNumber) {
		List<Order> orderList = new ArrayList<>();
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM orders WHERE ordernumber = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, orderNumber);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orderList.add(new Order(rs.getLong("ordernumber"), rs.getInt("user_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Order order = null;
		if(orderList.size() > 0) {
			order = orderList.get(0);
		}
		return order;
	}

	@Override
	public List<Order> selectOrderByCustomer(Customer c) {
		List<Order> orderList = new ArrayList<>();
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM orders WHERE user_id = (SELECT user_id FROM users WHERE customer_email = ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,c.getEmail());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orderList.add(new Order(rs.getLong("ordernumber"), rs.getInt("user_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public List<Order> selectAllOrders() {
		List<Order> orderList = new ArrayList<>();
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "SELECT * FROM orders;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orderList.add(new Order(rs.getLong("ordernumber"), rs.getInt("user_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public void updateOrder(Order o) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "UPDATE orders SET foodordered = ?, user_id = ? WHERE "
						+ "ordernumber = ?;"
						+ "(?,?,?)";
			
			Array foodArray = conn.createArrayOf("_text", o.getFoodOrdered().toArray());
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setArray(1, foodArray);
			ps.setInt(2, o.getUserId());
			ps.setLong(3, o.getOrderNumber());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(Order o) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "DELETE FROM orders WHERE "
						+ "ordernumber = ? AND foodordered = ? AND user_id = ?;"
						+ "(?,?,?);";
			
			Array foodArray = conn.createArrayOf("_text", o.getFoodOrdered().toArray());
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, o.getOrderNumber());
			ps.setArray(2, foodArray);
			ps.setInt(3, o.getUserId());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
