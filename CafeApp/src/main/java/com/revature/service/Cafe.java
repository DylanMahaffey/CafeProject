package com.revature.service;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.OrderDao;
import com.revature.dao.OrderDaoImpl;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Food;
import com.revature.models.User;

import java.util.List;
import java.util.Scanner;

public class Cafe {
	
	private static CustomerDao cDao =  new CustomerDaoImpl();
	private static EmployeeDao eDao =  new EmployeeDaoImpl();
	private static OrderDao oDao = new OrderDaoImpl();
	private static Cafe myCafe;
	private List<Food> cafeMenu;
	private Customer currCustomer;
	private Employee currEmployee;
	
	private Cafe() {
		//load food list
		//load customers
	}
	
	public void newOrder(Customer c) {
		
		cDao.updateCustomer(c);
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
	
	public void createCustomerProfile(String name, String email, String password) {
		/*
		 * List<Customer> cList = CustomerDao.selectAll()
		 * 
		 * if(cList.contains(c)){
		 * 		CustomerDao.insertCustomer(c);
		 * else
		 * 		syso("customer does not exist");
		 * 
		 */
		cDao.insertCustomer(new Customer(name, email, password));
		
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
	
	public User logIn(String username, String password) {
		User u = null;
		//if login doesnt exist 
		if(cDao.selectCustomerByEmail(username)!=null||eDao.selectEmployeeByEmail(username)!=null) {
			if(cDao.selectCustomerByEmail(username).getPassword().equals(password)) {
				u = cDao.selectCustomerByEmail(username);
			}
			else if(eDao.selectEmployeeByEmail(username).getPassword().equals(password)) {
				u = eDao.selectEmployeeByEmail(username);
			}
			else {} 
				
		}
		return  u;
		
	}
	
	public User getUserByEmail(String email) {
		
	}
		
	public void createMenu() {
		
		getMenu().add(new Food("Coffee",1.99));
		getMenu().add(new Food("Water",.99));
		getMenu().add(new Food("Tea",1.99));
		getMenu().add(new Food("Biscuit",1.99));
		getMenu().add(new Food("Bagel",.99));
		getMenu().add(new Food("Croissant",2.99));
	}
	
	
	
}
