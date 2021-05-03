package com.callor.db.service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.db.model.BookVO;
import com.callor.db.service.BookService;

public class BookServiceImplV1 implements BookService {

	protected Connection dbConn;
	
	public BookServiceImplV1() {
		this.dbConnection();
	}
	
	// DB에 연결하여 CRUD 구현을 하기 위한 준비를 하는 method()
	private void dbConnection() {
		// 버전마다 약간의 차이가 있어서
		// java9 이상에서는 jdbc.OracleDriver를 사용한다
		
		/*
		 * WAS 프로젝트에서 ojdbc6.jar를 사용할 경우
		 * Tomcat 폴더의 lib 폴더에
		 * ㅐㅓ윷6.ㅓㅁㄱ 를 추가해 줄것
		 */
		// oracle.jdbc.driver.OrableDriver
		String dbDriver = "oracle.jdbc.OracleDriver";
		
		// 프로젝트에서 SQL을 실행하면
		// URL로 설정된 통로를 통해서 명령을 전달하고
		// 결과를 받겠다
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bookuser";
		String password = "bookuser";
		
		try {
			// oracle에 접속할 미들웨어를 실행하라
			// java 7 이상에서는 선택적이다
			Class.forName(dbDriver);
			
			//url, user, password 정보를 사용해서
			// oracle에 접속하라
			dbConn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Override
	public void insert(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookVO> selectAll() {
		// TODO 전체 도서정보 조회 후 return
		
		// SQL을 DBMS로 전할때 사용할 보조 도구
		PreparedStatement pStr = null;
		String sql = "SELECT * FROM tbl_books";
		
		// 문자열로 되어있는 SQL 명령을
		// URL을 통해 DB로 전송하기 위해 packing하라
		
		/*
		 * packet으로 만들어라
		 * 네트워크를 통해서 데이터를 주고 받으려면
		 * 데이터 외에 여러가지 정보들이 포함되어야 한다
		 * 받는 곳 주소, 보내는 곳 주소...
		 */
		try {
			pStr = dbConn.prepareStatement(sql);
			
			//packing된 명령을  DBMS로 전송하라
			// 전송된 명령ㅇ르 실행한 결과를 
			// ResultSet 타입의 데이터로 return해준다
			ResultSet result = pStr.executeQuery();
			
			
			List<BookVO> bookList = new ArrayList<BookVO>();
			
			while(result.next()) {
				
				// return 받은 결과에서 데이터 한개를 읽을 준비 시작
				// 읽은 데이터가 있으면 true를 return
				// 더이상 데이터가 없으면 false를 return
				BookVO bookVO = new BookVO();
				bookVO.setBk_isbn(result.getString("bk_isbn"));
				bookVO.setBk_title(result.getString("bk_title"));
			
				bookVO.setBk_ccode(result.getString("bk_ccode"));
				bookVO.setBk_acode(result.getString("bk_acode"));
				bookVO.setBk_date(result.getString("bk_date"));
				bookVO.setBk_price(result.getString("bk_price"));
				bookVO.setBk_pages(result.getInt("bk_pages"));
				bookList.add(bookVO);
				System.out.println(bookVO.toString());
				
			}
			result.close();
			pStr.close();
			return bookList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	// bk_isbn1OR1;
	@Override
	public BookVO findById(String bk_isbn) {
		// TODO ISBN으로 도서 정보 조회 후 데이터 return
		PreparedStatement pStr = null;
		String sql = "SELECT * FROM view_도서정보 WHERE ISBN = '" + bk_isbn + "'";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();
			if(result.next()) {
				BookVO bookVO = new BookVO();
				bookVO.setBk_title(result.getString("도서명"));
				bookVO.setBk_isbn(result.getString("ISBN"));
				bookVO.setBk_acode(result.getString("저자명"));
				bookVO.setBk_ccode(result.getString("출판사명"));
				return bookVO;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}

	@Override
	public List<BookVO> findTitle(String bk_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String bk_comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String bk_isbn) {
		// TODO ISBN을 전달받아서 데이터 삭제
		
		String sql = "DELETE FROM * tbl_books WHERE bk_isbn";
		
	}

}
