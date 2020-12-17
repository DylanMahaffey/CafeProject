package com.revature.views;

import java.util.ArrayList;
import java.util.List;

import com.revature.Router;
import com.revature.StateManager;
import com.revature.models.Food;
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
		System.out.println("1 - Start new order");
		int ui = StateManager.getScanner().nextInt();
		
		switch(ui) {
			case 0:
				logout();
				break;
			case 1:
				order();
				break;
				
		}
	}
	
	public static void logout() {
//		getCafe().logOut();
		StateManager.loggedInUser = null;
		Router.getWelcomeView().start();
	}
	
	public static void order() {
		StateManager.printSpacer();
		List<Food> menu = getCafe().getMenu();
		List<Food> customerOrder = new ArrayList<Food>();
		
		int foodSelector = 1;
		for(Food f : menu) {
			System.out.println(foodSelector + " - " + f.getName() + ": " + f.getPrice());
			foodSelector++;
		}
		
		boolean ordering = true;
		while (!ordering) {
			int orderedItem = StateManager.getScanner().nextInt() - 1;
			
			if(orderedItem - 1 > menu.size() || orderedItem - 1 < 0) {
				
			}
			
		}
		
	}

}
