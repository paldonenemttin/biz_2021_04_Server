package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO나 DTO는 DB와 관련한 데이터를 ㅇㄻ길대 사용하는 객체
 * 대부부느이 역할이 유사하지만
 * 특별히 구분을 하는 이유는
 * 한개의 Table에 대하여
 * 다양한 View를 사용할때
 * 여러개의 VO 나 DTO를 만들면서
 * 이름을 짓는 것이 번거로워서 구분을 한다
 * 
 * MyFoodVO : insert, update
 * MyFoodDTO : Select
 * 
 * DTO(DATA Transfer Object)
 * DB로 부터 Select 데이털르 출력하는 곳으로
 * 옮길때 사용할 객체
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodDTO {

	/*
	 * 복붙 블록후 컨트롤 f find public replace private
	 */

	private long mf_seq; // number
	private String mf_date; // varchar2(10 byte)
	private String mf_fcode; // char(7 byte)
	private String mf_fname;
	private Float mf_amt; // number(10,2)
	private Float fd_once;
	private Float fd_capa;
	private Float fd_cal;
	private Float fd_protein;
	private Float fd_fat;
	private Float fd_carbo;
	private Float fd_sugar;


}
