package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Order;

public interface OrderDao {
	
	//CREATE
	public void insertOrder(Order o);
	
	//READ
	public Order selectOrderByOrderNumber(long oN);
	public List<Order> selectOrderByCustomer(Customer c);
	public List<Order> selectAllOrders();
	
	//UPDATE
	public void updateOrder(Order o);
	
	//DELETE
	public void deleteOrder(Order o);

}
