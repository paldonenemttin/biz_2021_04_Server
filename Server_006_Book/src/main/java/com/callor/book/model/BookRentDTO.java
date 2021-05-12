package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 주문번호	NUMBER br_seq
 * 대여일	VARCHAR2(10) 
 * 회원코드	CHAR(5) br_bcode
 * 회원명	NVARCHAR2(50)bu_name
 * 회원연락처	VARCHAR2(20) bu_tel
 * ISBN	CHAR(13)
 * 도서명	NVARCHAR2(125)
 * 반납일	VARCHAR2(10)
 * 대여금	NUMBER
 * 
 * 조회할때(SELECT) Service 각 method가 return;
 */
@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class BookRentDTO {
	
	private Long br_seq;
	private String br_bcode;
	private String br_bname;
	private String br_tel;
	private String br_isbn;
	private String br_title;
	private String br_edate;
	
	private Integer br_price = 0;
	private String br_sdate;
	

}
