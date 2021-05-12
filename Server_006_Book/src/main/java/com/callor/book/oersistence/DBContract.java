package com.callor.book.oersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DB연동ㅇ르 위한  dbConnect 객체를 미리 생성해두고
 * 필요할때 사용할 수 있도록 하는 클래스
 * static class로 생성
 * 클래스에 포함된 필드변수ㅡ 맴버 method 중
 * 1개 라도  static 키워드가 부착되면 static class 가 된다
 * 프로젝트다  Run되는 순간 미리 객체로 생성되어
 * 준비되는 클래스
 */
public class DBContract {
	
	public static Connection dbConn = null;
	
	static {
		
		String jdbcdriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "bookuser";
		String password = "bookuser";
		
		try {
			//자바 1.7 이상에서는 사용하지 않아도 되는 코드
			Class.forName(jdbcdriver);
			
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("오라클 접속 ok");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 서버 못찾음");
			System.out.println("오라클 ojdbc6.jar 확인하셈");
		} catch (SQLException e) {
			System.out.println("=".repeat(30));
			System.out.println("오라클 연결 실패");
			System.out.println("접속 정보 확인 필요");
			System.out.println("URL : " + url);
			System.out.println("User : " +username);
			System.out.println("PW: " + password);
			System.out.println("=".repeat(30));
		}
	}// end static 내뇌 폭사 전날 수면 불량으로 인한 집중력과 뇌기능의 저하로 인해 시스템을 종료합니다 삐삐 삐......
	
	public static Connection getDBConnection() {
		return dbConn;
	}
	
	

}
