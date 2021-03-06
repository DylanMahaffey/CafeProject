package com.revature.service;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.OrderDao;
import com.revature.dao.OrderDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Food;
import com.revature.models.Order;
import com.revature.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cafe {
	
	private static UserDao uDao =  new UserDaoImpl();
	private static CustomerDao cDao =  new CustomerDaoImpl();
	private static EmployeeDao eDao =  new EmployeeDaoImpl();
	private static OrderDao oDao = new OrderDaoImpl();
	
	private static Cafe myCafe;
	private List<Food> cafeMenu;
	private Customer currCustomer;
	private Employee currEmployee;
	
	private Cafe() {
		cafeMenu = new ArrayList<Food>();
		createMenu();
	}
	
	public Order newOrder(Order o) {
		
		currCustomer.getOrders().add(o);
		oDao.insertOrder(o);
		cDao.updateCustomer(currCustomer);
		return o;
	}
	
	public void updateUser(Customer c) {
		
		uDao.updateUser(c);
	}
	
	public void deleteUser(Customer c)
	{
		//this should take care of all foreign key constraints
		for(Order o: currCustomer.getOrders())
		{
			deleteOrder(o);
		}
		//delete customer after all associated orders are deleted
		uDao.deleteUser(c);
	}
	
	public void deleteOrder(Order o) {
		oDao.deleteOrder(o);
	}
	
	public User createCustomerProfile(String name, String email, String password) {

		Customer c = new Customer(name, email, password);
		uDao.insertUser(c);
		
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
        User u = cDao.selectCustomerByEmail(username);
        currCustomer = (Customer) u;
        if(u == null) {
        	u = eDao.selectEmployeeByEmail(username);
        	currEmployee = (Employee) u;
        }
        System.out.println(u);
        //if login doesnt exist 
        if(u == null) {
            System.out.println("Invalid Email");
            }
        else if(u.getPassword().equals(password)){
            	return u;
            }
        else {
        	System.out.println("Wrong Password");
        	logOut();
        }
        return  u;
        }
       

		
	
	
	public User getUserByEmail(String email) {
		User u = null;
		try {
			u = cDao.selectCustomerByEmail(email);
		        if(u == null) {
		        	u = eDao.selectEmployeeByEmail(email);
		        	if(u == null) {
		        		System.out.println("Email does not exist");
		        	}
		        }
		        System.out.println(u);
		}
		catch (IndexOutOfBoundsException e) {
			return u;
		}
		return u;	
	}
	
	public List<Customer> getLoyalCustomers(){
		List<Customer> loadlist = cDao.selectAllCustomers();
		//might not even need the return list, possible to just remove customers that have
		//orders 10 or less, return the remaining list
		
		//List<Customer> returnlist = new ArrayList<Customer>();
		for(Customer c: loadlist) {
			if(c.getOrders().size() <= 10) {
				loadlist.remove(c);
			}
		}
		return loadlist;
	}
		
	public void createMenu() {
		
		cafeMenu.add(new Food("Coffee",1.99));
		cafeMenu.add(new Food("Water",.99));
		cafeMenu.add(new Food("Tea",1.99));
		cafeMenu.add(new Food("Biscuit",1.99));
		cafeMenu.add(new Food("Bagel",.99));
		cafeMenu.add(new Food("Croissant",2.99));
	}
	
	public void logOut() {
		currCustomer = null;
		currEmployee = null;
	}
	
	
}
