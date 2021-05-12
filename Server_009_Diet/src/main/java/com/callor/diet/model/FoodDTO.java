package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

	private String fd_code;// char(7 byte)
	private String fd_name; // nvarchar2(125 char)
	private Integer fd_year; // number
	private String fd_ccode; // char(6 byte)
	private String fd_icode; // char(4 byte)
	
	private Float fd_once; // number(10,2)
	private Float fd_capa; // number(10,2)
	private Float fd_cal; // number(10,2)
	private Float fd_protein; // number(10,2)
	private Float fd_fat; // number(10,2)
	private Float fd_carbo; // number(10,2)
	private Float fd_sugar; // number(10,2)
	
	private String cp_name;		//	제조사명
	private String cp_ceo;		//	대표
	private String cp_tel;		//	대표전화
	private String cp_addr;		//	주소
	private String cp_item;		//	주요품목
		
	private String it_name;		//	분류명

	
	
}
