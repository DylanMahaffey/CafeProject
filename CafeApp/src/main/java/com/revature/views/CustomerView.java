package com.revature.views;

import com.revature.Router;
import com.revature.StateManager;
import com.revature.models.User;
import com.revature.service.Cafe;

public class CustomerView {
	
private static Cafe cafe;
	
	private static Cafe getCafe() {
		if (cafe == null) {
			cafe = Cafe.createCafe();
		}
		return cafe;
	}
	
	public static void start() {
		StateManager.printSpacer();
		User customer = StateManager.loggedInUser;
		if (customer == null) {
			Router.getWelcomeView().start();
			return;
		}
		System.out.println("Welcome " + customer.getName() + "!");
		System.out.println("0 - Log Out");
		int ui = StateManager.getScanner().nextInt();
		
		switch(ui) {
			case 0:
				logout();
				break;
		}
	}
	
	public static void logout() {
		getCafe().logOut();
		StateManager.loggedInUser = null;
		Router.getWelcomeView().start();
	}

}
