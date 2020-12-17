package com.revature.views;

import com.revature.Router;
import com.revature.StateManager;
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
				break;
			case 2:
				break;
			case 3:
				break;
				
		}
	}
	
	public static void logout() {
		StateManager.loggedInUser = null;
		Router.getWelcomeView().start();
	}
}
