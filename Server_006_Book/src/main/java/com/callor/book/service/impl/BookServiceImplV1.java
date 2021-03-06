package com.callor.book.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.book.model.BookDTO;
import com.callor.book.oersistence.DBContract;
import com.callor.book.oersistence.DBInfo;
import com.callor.book.service.BookService;

public class BookServiceImplV1 implements BookService{

	protected Connection dbConn;
	
	public BookServiceImplV1() {
		// TODO Auto-generated constructor stub
		dbConn = DBContract.dbConn;
	}
	
	protected List<BookDTO> select(PreparedStatement pStr) throws SQLException{
		List<BookDTO> bookList = new ArrayList<BookDTO>();
		ResultSet rSet= pStr.executeQuery();
		while(rSet.next()) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBk_isbn(rSet.getInt(DBInfo.BOOK.bk_isbn));
			bookDTO.setBk_title(rSet.getString(DBInfo.BOOK.bk_title));
			bookDTO.setBk_cceo(rSet.getString(DBInfo.BOOK.bk_cceo));
			bookDTO.setBk_cname(rSet.getString(DBInfo.BOOK.bk_cname));
			bookDTO.setBk_auname(rSet.getString(DBInfo.BOOK.bk_auname));
			bookDTO.setBk_autel(rSet.getString(DBInfo.BOOK.bk_autel));
			bookDTO.setBk_date(rSet.getString(DBInfo.BOOK.bk_date));
			bookDTO.setBk_price(rSet.getInt(DBInfo.BOOK.bk_price));
			bookDTO.setBk_pages(rSet.getInt(DBInfo.BOOK.bk_pages));
		}
		rSet.close();
		
		return bookList;
	}
	
	@Override
	public List<BookDTO> selectAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM view 도서정보";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BookDTO findById(String bk_isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> findByTitle(String bk_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> findByCName(String bk_cname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> findByAName(String bk_aname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
