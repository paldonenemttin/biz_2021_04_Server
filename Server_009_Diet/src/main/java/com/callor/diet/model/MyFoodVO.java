package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO 클래스는 insert update를 수행할때
 * 사용자(Web)가 입력한(전달받은) 값을 담을 객체
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodVO {

	public long mf_seq; // number
	public String mf_date; // varchar2(10 byte)
	public String mf_fcode; // char(7 byte)
	public Float mf_amt; // number(10,2)

}
