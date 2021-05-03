package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;

// BookRenttable의  CRUD를 구현하기 위한 인터페이스 구현
public interface BookRentService {
	
	public List<BookRentDTO> selectAll();
	
	// pk 값으로 조회하기
	public List<BookRentDTO> findById(Long seq);
	
	// 도서코드로 대여목록 조회
	public List<BookRentDTO> findByISBN(String isbn);
	
	// 도서명을 대여목록 조회
	public List<BookRentDTO> findByBN(String name);
	
	// 회원코드로 대여목록 조회
	public List<BookRentDTO> findByBC(String bcode);
	
	// 회원명으로 대여목록 조회
	public List<BookRentDTO> findByBuyerName(String bname);
	
	//미반납으로 대여목록 조회
	// 연체자목록
	public List<BookRentDTO> findOD(String eDate);
	
	// 대여일자를 지정하여 목록조회
	public List<BookRentDTO> findByTerm(String sDate, String eDate);
	
	// prepare.. 를 통해서 SQL을 실행하면
	// CUR가 정상적으로 수행되면 결과값이 정수 1이상이 되돌아오고
	// 그렇지 못하면 0값이 되돌아 온다
	public int insert(BookRentVO bookrentVO);
	public int update(BookRentVO bookrentVO);
	public int delete(Long seq);
	

}
