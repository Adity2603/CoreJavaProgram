package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//contains method that can open a connection and return connection object
public class ConnectionFactory {
	public static Connection getConnection() {
		Connection myConnection = null;
	    String url = "jdbc:mysql://localhost:3306/payxpert?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String username = "root";
		String password = "amd12345";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//registering driver
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		try {
			myConnection = DriverManager.getConnection(url, username, password );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return myConnection;
 
	}
 
}