package com.revature;

import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.UserDaoImpl;

public class Driver {

	public static void main(String [] args) {
		Router.getWelcomeView().start();
//		EmployeeDaoImpl edao = new EmployeeDaoImpl();
//		CustomerDaoImpl cdao = new CustomerDaoImpl();
//		UserDaoImpl udao = new UserDaoImpl();
//		System.out.println(udao.selectUserByEmail("admin@cafe.com"));
//		System.out.println(cdao.selectCustomerByEmail("marc.settin@email.com"));
//		System.out.println(edao.selectEmployeeByEmail("admin@cafe.com"));
	}
	
}
