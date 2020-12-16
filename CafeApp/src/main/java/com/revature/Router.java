package com.revature;

import com.revature.views.CustomerView;
import com.revature.views.WelcomeView;

public class Router {
	
	private static WelcomeView welcomeView;
	private static CustomerView customerView;
	
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

}
