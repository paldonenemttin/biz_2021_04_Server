package com.callor.diet.service;

import java.util.List;

import com.callor.diet.model.MyFoodDTO;
import com.callor.diet.model.MyFoodVO;

public interface MyFoodService {
	
	public List<MyFoodDTO> selectAll();
	public MyFoodDTO findId(Long seq);
	
	public List<MyFoodDTO> findName(String mf_name);

	public List<MyFoodDTO> findDate(String mf_date);
	
	public Integer insert(MyFoodVO myFoodVO);
	public Integer update(MyFoodVO myFoodVO);
	public Integer delete();

}
