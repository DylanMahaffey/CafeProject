package com.revature.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Food;
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
				Array foodArray = rs.getArray("foodordered");
				String[] foods = (String[])foodArray.getArray();
				List<Food> foodList = new ArrayList<>();
				for(int i=0; i<foods.length; i++) {
					//foodArray.
				}
				orderList.add(new Order(rs.getLong("ordernumber"), rs.getInt("user_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> selectOrderByCustomer(Customer c) {
		try(Connection conn = DB_Connection.getConnection()){
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> selectAllOrders() {
		try(Connection conn = DB_Connection.getConnection()){
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrder(Order o) {
		try(Connection conn = DB_Connection.getConnection()){
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(Order o) {
		try(Connection conn = DB_Connection.getConnection()){
			String sql = "DELETE FROM orders WHERE "
						+ "foodordered = ? AND user_id = ?;"
						+ "(?,?);";
			
			Array foodArray = conn.createArrayOf("_text", o.getFoodOrdered().toArray());
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setArray(1, foodArray);
			ps.setInt(2, o.getUserId());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
