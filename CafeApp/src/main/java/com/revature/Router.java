package com.revature;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.views.*;

public class Router {
	
	private static WelcomeView welcomeView;
	private static CustomerView customerView;
	private static EmployeeView employeeView;
	
	public static WelcomeView getWelcomeView() {
		if (welcomeView == null) {
			welcomeView = new WelcomeView();
		}
		
		return welcomeView;
	}
	
	public static CustomerView getCustomerView() {
		if (customerView == null) {
			customerView = new CustomerView();
		}
		
		return customerView;
	}
	
	public static EmployeeView getEmployeeView() {
		if (employeeView == null) {
			employeeView = new EmployeeView();
		}
		
		return employeeView;
	}
	
	public static void loggingInUser(User u) {
		if (u instanceof Customer) {
			getCustomerView().start();
		} else if (u instanceof Employee) {
			getEmployeeView().start();
		} else {
			System.out.println("There was an error logging in.");
		}
	}

}
