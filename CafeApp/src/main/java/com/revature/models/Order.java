package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
	
	private long orderNumber;
	private List<Food> foodOrdered;	
	private int userId;
	
	
	
	public Order(long orderNumber, int userId, List<Food> foodOrdered) {
		super();
		this.orderNumber = orderNumber;
		this.foodOrdered = foodOrdered;
		this.userId = userId;
	}



	public Order(long orderNumber, int userId) {
		this(orderNumber, userId, new ArrayList<>());
	}

	public Order(int userId) {
		this(new Random().nextLong(), userId);
	}

	public long getOrderNumber() {
		return orderNumber;
	}



	public List<Food> getFoodOrdered() {
		return foodOrdered;
	}



	public int getUserId() {
		return userId;
	}



	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}



	public void setFoodOrdered(List<Food> foodOrdered) {
		this.foodOrdered = foodOrdered;
	}
	public void addItemToOrder(Food f) {
		this.foodOrdered.add(f);
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getTotal() {
		int total = 0;
		for(Food f : this.foodOrdered) {
			total += f.getPrice();
		}
		return total;
	}



	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", foodOrdered=" + foodOrdered + ", userId=" + userId + "]";
	}
	
	
	

}
