package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContract {

	private static Connection dbConn;
	
	static {
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";// mysql은 cj가 최신버전 권장
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "gbUser";
		String password = "1234";

		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, user, password);
			}
			System.out.println("muysql 접속");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// get Instance method
	// Instance : 사용준비(생성된, 초기화된) 객체
	// private static으로 선언된 변수, 객체를
	// 다른 곳에서 사용할 수 있도록 제공하는 method
	public static Connection getDbConn() {
		return dbConn;
	}
}
