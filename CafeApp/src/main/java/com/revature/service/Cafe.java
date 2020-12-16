package com.revature.service;

import com.revature.dao.CustomerDao;
import com.revature.models.Customer;
import com.revature.models.Food;

import java.util.List;

public class Cafe {
	
	private CustomerDao cDao;
	private static Cafe myCafe;
	private List<Food> cafeMenu;
	private Customer currCustomer;
	//private List<Users> userList;
	
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
		//if fields exist in list of users, set currUser to 
	}
	
	public void getCustomerList() {
		//customerList = cDao.getCustomers();
	}
	
	
	public void createMenu() {
		//hard code all the food in
	}
	
}
