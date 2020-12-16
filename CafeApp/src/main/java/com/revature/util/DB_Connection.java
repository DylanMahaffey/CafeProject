package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

	private static final String URL = "jdbc:postgresql://aws-database.cncn9hvo0drr.us-east-2.rds.amazonaws.com/postgres";
	private static final String USERNAME = "java_login";
	private static final String PASSWORD = "Password1234";
	
	private static Connection connection;
	
	public static Connection getConnection()
	{
		try 
		{
			if(connection == null)
			{
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		return connection;
	}
}
