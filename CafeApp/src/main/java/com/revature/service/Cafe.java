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
import com.revature.models.Order;
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
	
	public Order newOrder(Order o) {
		
		currCustomer.getOrders().add(o);
		oDao.insertOrder(o);
		cDao.updateCustomer(currCustomer);
		return o;
	}
	
	public void updateCustomer(Customer c) {
		
		cDao.updateCustomer(c);
	}
	
	public void deleteCustomer(Customer c) {
		cDao.deleteCustomer(c);
	}
	
	public void deleteOrder(Order o) {
		oDao.deleteOrder(o);
	}
	
	public User createCustomerProfile(String name, String email, String password) {

		Customer c = new Customer(name, email, password);
		cDao.insertCustomer(c);
		
		return c;
		
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
		if(getUserByEmail(username)) {
			if(cDao.selectCustomerByEmail(username).getPassword().equals(password)) {
				u = cDao.selectCustomerByEmail(username);
				currCustomer = (Customer) u;
			}
			else if(eDao.selectEmployeeByEmail(username).getPassword().equals(password)) {
				u = eDao.selectEmployeeByEmail(username);
				currEmployee = (Employee) u;
			}
			else {} 
				
		}
		return  u;
		
	}
	
	public boolean getUserByEmail(String email) {
<<<<<<< HEAD
		//fluff
		if(cDao.selectCustomerByEmail(email)!=null||eDao.selectEmployeeByEmail(email)!=null) {
			return true;
		}
		return false;
=======
		if(cDao.selectCustomerByEmail(email)!=null||eDao.selectEmployeeByEmail(email)!=null)
		
>>>>>>> b35ef2a2e760aa71523b27719f3380e1924a51ba
		
	}
	
		
	public void createMenu() {
		getMenu().add(new Food("Coffee",1.99));
		getMenu().add(new Food("Water",.99));
		getMenu().add(new Food("Tea",1.99));
		getMenu().add(new Food("Biscuit",1.99));
		getMenu().add(new Food("Bagel",.99));
		getMenu().add(new Food("Croissant",2.99));
	}
	
	public void logOut() {
		currCustomer = null;
		currEmployee = null;
	}
	
	
}
