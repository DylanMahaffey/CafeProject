package com.revature.views;

import java.util.ArrayList;
import java.util.List;

import com.revature.Router;
import com.revature.StateManager;
import com.revature.models.Customer;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.service.Cafe;

public class EmployeeView {
	
private static Cafe cafe;
	
	private static Cafe getCafe() {
		if (cafe == null) {
			cafe = Cafe.createCafe();
		}
		return cafe;
	}
	
	public static void start() {
		StateManager.printSpacer();
		User employee = StateManager.loggedInUser;
		if (employee == null) {
			Router.getWelcomeView().start();
			return;
		}
		System.out.println("Welcome " + employee.getName() + "!");
		System.out.println("0 - Log Out");
		System.out.println("1 - Delete Customer");
		System.out.println("2 - Update Customer");
		System.out.println("3 - View Large Orders");
		int ui = StateManager.getScanner().nextInt();
		
		switch(ui) {
			case 0:
				logout();
				break;
			case 1:
				deleteCustomer();
				break;
			case 2:
				updateCustomer();
				break;
			case 3:
				getLargeOrders();
				break;
				
		}
	}
	
	public static void logout() {
		StateManager.loggedInUser = null;
		Router.getWelcomeView().start();
	}
	
	public static void deleteCustomer() {
		Customer customer = null;
		
		StateManager.printSpacer();
		System.out.print("Enter Customer email: ");
		String email = StateManager.getScanner().next();
		
		boolean searching = true;
		while(searching) {
			customer = (Customer) cafe.getUserByEmail(email);
			if (customer != null) {
				cafe.deleteUser(customer);
				searching = false;
			}
			else {
				System.out.println("No user with email: " + email + " found.");
				email = StateManager.getScanner().next();
				System.out.print("Enter Customer email: ");
			}
		}
	}
	
	public static void updateCustomer() {
		Customer customer = null;
		
		StateManager.printSpacer();
		System.out.print("Enter Customer email: ");
		String email = StateManager.getScanner().next();
		
		boolean searching = true;
		while(searching) {
			customer = (Customer) cafe.getUserByEmail(email);
			if (customer != null) {
				cafe.updateUser(customer);
				searching = false;
			}
			else {
				System.out.println("No user with email: " + email + " found.");
				email = StateManager.getScanner().next();
				System.out.print("Enter Customer email: ");
			}
		}
	}
	public static void getLargeOrders() {
		List<Customer> customers = new ArrayList<Customer>();
		List<Order> orders = new ArrayList<Order>();
		
		StateManager.printSpacer();
		customers = cafe.getLoyalCustomers();
		
		for(Customer customer : customers) {
			System.out.println("Customer: " + customer.getName());
			orders = customer.getOrders();
			for(Order order : orders) {
			System.out.println("Order Number: " + order.getOrderNumber());
			System.out.println("Food ordered: " + order.getFoodOrdered());
			System.out.println("Total: " + order.getTotal());
			StateManager.printSpacer();
			}
		}
		
	}
}
