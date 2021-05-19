package com.callor.guest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {

	public static Connection dbConn;

	static {
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://192.168.5.41:3306/guestbook";
		String username = "gbUser";
		String password = "1234";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("mysql 접속 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public static Connection getDBConnection() {
		// TODO Auto-generated method stub
		return dbConn;
	}

	 
}
