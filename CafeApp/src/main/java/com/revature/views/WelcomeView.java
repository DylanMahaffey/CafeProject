package com.revature.views;

import com.revature.Router;
import com.revature.StateManager;
import com.revature.models.User;
import com.revature.service.Cafe;

public class WelcomeView {
	
	private static Cafe cafe;
	
	private static Cafe getCafe() {
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
		String email;
		String password;
		
		boolean emailOK = false;
		while (!emailOK) {
			System.out.println("Enter your email");
			String email = StateManager.getScanner().next();
			if (!getCafe().getUserByEmail(email)) {
				System.out.println("Email already exists");
				continue;
			} else {
				emailOK = true;
				break;
			}
			
		}
		
		boolean passwordOK = false;
		while(!passwordOK) {
			System.out.println("Enter Password");
			password = StateManager.getScanner().next();			

			System.out.println("Confirm Password");
			String confPassword = StateManager.getScanner().next();		
			
			if (password.equals(confPassword)) {
				passwordOK = true;
				break;
			} else {
				System.out.println("Passwords do not match");
				continue;
			}
		}
		
		User u = getCafe().createCustomerProfile(name, email, password);
		if (u == null) {
			System.out.println("There was an error creating your account.");
		} else {
			Router.loggingInUser(u);
		}
		
	}

}
