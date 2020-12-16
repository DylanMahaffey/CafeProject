package com.revature;

import java.util.Scanner;

import com.revature.models.User;

public class StateManager {
	
	public static User loggedInUser;
	public static Scanner sn;
	
	public static Scanner getScanner() {
		if (sn == null) {
			sn = new Scanner(System.in);
		}
		return sn;
	}
	
	public static void printSpacer() {
		System.out.println("---------------------------------");
	}

}
