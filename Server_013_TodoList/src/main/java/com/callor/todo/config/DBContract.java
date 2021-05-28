package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 
 * 싱글톤 패턴
 * 자원(resouce:하드웨어장치, 네트워크, 파일...) 을
 * 코드에서 활용할때는 최소한의 연결을 하여
 * 사용하는 것이 여러모로 좋다
 * 
 * 필요한 연결객체를 프로젝트에서 1개만 선언하고
 * 공용으로 사용하는 방법
 */
public class DBContract {
	
	protected static final Logger log = LoggerFactory.getLogger("DB");
	private static Connection dbConn;
	// static 초기화블록 
		// static으로 선언된 변수난 객체를 프로젝트가 시작될때
		// 자동으로 생성하는 코드를 작성하는 부분
		//
		// Connection 객체인 dbConn을 사용할 준비를 하기
		// DB
	static {

		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "gbUser";
		String password = "1234";

		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, user, password);
			}
			//System.out.println("muysql 접속");
			log.debug("mysql 연결");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getDbConn() {
		return dbConn;
	}

}
