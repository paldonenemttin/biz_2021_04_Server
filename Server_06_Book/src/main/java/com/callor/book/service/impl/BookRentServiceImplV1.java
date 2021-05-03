package com.callor.book.service.impl;

import java.util.List;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.service.BookRentService;

public class BookRentServiceImplV1 implements BookRentService {

	
	@Override
	public List<BookRentDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected List<BookRentDTO> select(PrepareStatement pStr){
		List<BookRentDTO> brList = new ArrayList<>();
		
		dk whweoTek
		
		또 미친놈 이야기를 써야 하나 시간 안간다 망했다 하나도 못따라잡았어
		아 아 아 7교시에 또 존나 쓸텐데
		
		return brList;
	}

	@Override
	public List<BookRentDTO> findById(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookRentDTO> findByISBN(String isbn) {
		// TODO isbn으로 조회
		String sql = "SELECT * FROM view_도서대여정보";
		sql += "WHERE ISNM = ?";
		
		Prep
		return null;
	}

	@Override
	public List<BookRentDTO> findByBN(String name) {
		// TODO 도서명으로 조회
		String sql = "SELECT * FROM view_도서대여정보";
		sql += "WHERE 도서명 LIKE '%' || ? || '%'";
		PreparedStatement pStr = null;
		return null;
	}

	@Override
	public List<BookRentDTO> findByBC(String bcode) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 이 세상에 또다른 미친놈이 나타났다
	 * 경찰서에서 폭사하며 대스타가 됐다고 좋아한 쓰레기와는 결이 다르다
	 * 
	 */
	

	@Override
	public List<BookRentDTO> findByBuyerName(String bname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookRentDTO> findOD(String eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookRentDTO> findByTerm(String sDate, String eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookRentVO bookrentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookRentVO bookrentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		return 0;
	}


	음 집가서망했구,,,, 

	
}
