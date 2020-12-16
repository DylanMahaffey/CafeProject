package com.revature.service;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Food;
import com.revature.models.User;

import java.util.List;
import java.util.Scanner;

public class Cafe {
	
	private static CustomerDao cDao =  new CustomerDaoImpl();
	private static EmployeeDao eDao =  new EmployeeDaoImpl();
	private static Cafe myCafe;
	private List<Food> cafeMenu;
	private Customer currCustomer;
	private Employee currEmployee;
	
	private Cafe() {
		//load food list
		//load customers
	}
	
	public void newOrder(Customer c) {
		
		
		/*
		 * 
		 * sc = scanner.ask(What do you want?)
		 * inputFood = sc.nextLine();
		 * 
		 * Order o = new Order();
		 * o.add(inputFood);
		 * 
		 *In service layer we leverage our dao layer
		 * 
		 * CustomerDao cs = new CustomerDaoImpl();
		 * 
		 * cs.insertOtder(o);
		 * cs.updateCustomer(c);
		 * 
		 */
		
		
	}
	
	public void createCustomerProfile() {
		/*
		 * List<Customer> cList = CustomerDao.selectAll()
		 * 
		 * if(cList.contains(c)){
		 * 		CustomerDao.insertCustomer(c);
		 * else
		 * 		syso("customer does not exist");
		 * 
		 */
		
		
	}
	
	public static Cafe createCafe() {
		if(myCafe == null) {
			myCafe = new Cafe();
		}
		return myCafe;
	}
	
	
	public List<Food> getMenu(){
		return cafeMenu;
	}
	
	public void logIn(String username, String password) {
		//if login doesnt exist 
		createCustomerProfile();
	}
	
	public void getCustomerList() {
		//implement customers 
	}
	
	
	public void createMenu() {
		//hard code all the food in
	}
	
	
	
}
