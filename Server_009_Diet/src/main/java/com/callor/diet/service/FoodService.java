package com.callor.diet.service;

import java.util.List;

import com.callor.diet.model.FoodDTO;

public interface FoodService {
	
	// CRUD를 구현할 method 정의(설계)
	
	// data 조회
	public List<FoodDTO> selectAll(); // 전체 조회
	public FoodDTO findById(); // 코드 조회
	public List<FoodDTO> findByFname(String f_name); // 이름 조회
	
	
	// 데이터 변환(추가, 수정, 삭제)
	public Integer insert();
	public Integer update();
	public Integer delete();

}
