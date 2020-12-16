package com.revature.views;

import com.revature.Router;
import com.revature.StateManager;
import com.revature.models.User;
import com.revature.service.Cafe;

public class WelcomeView {
	
	public static Cafe cafe;
	
	public static Cafe getCafe() {
		if (cafe == null) {
			cafe = Cafe.createCafe();
		}
		return cafe;
	}
	
	public static void start() {
		System.out.println("Welcome to the cafe!");
		System.out.println("1 - Log In");
		System.out.println("2 - Register");
		
		String ui = StateManager.getScanner().next();
		
		switch(ui) {
			case "1":
				login();
				break;
			case "2":
				register();
				break;
		}
	}
	
	public static void login() {
		StateManager.printSpacer();
		System.out.println("Enter email");
		String email = StateManager.getScanner().next();
		System.out.println("Enter Password");
		String password = StateManager.getScanner().next();
		
		// This is where I will call your login to get a user back
		// Cafe.loginMethod();
		User u = getCafe().logIn(email, password);
		if (u == null) {
			System.out.println("There Username/Password was incorrect");
		} else {
			Router.loggingInUser(u);
		}
	}
	
	public static void register() {
		StateManager.printSpacer();
		System.out.println("Enter your full name");
		String name = StateManager.getScanner().next();
	}

}
