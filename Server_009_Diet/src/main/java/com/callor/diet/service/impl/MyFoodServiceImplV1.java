package com.callor.diet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.diet.config.DBContract;
import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.MyFoodDTO;
import com.callor.diet.model.MyFoodVO;
import com.callor.diet.service.MyFoodService;

public class MyFoodServiceImplV1 implements MyFoodService {

	protected Connection dbConn;

	public MyFoodServiceImplV1() {
		// TODO Auto-generated constructor stub
		
		dbConn = DBContract.getDBConnection();
	}
	
	public List<MyFoodDTO> select(PreparedStatement pStr) throws SQLException{
		List<MyFoodDTO> mfList = new ArrayList<MyFoodDTO>();
		
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			MyFoodDTO dto = new MyFoodDTO();
			
			dto.setMf_seq((Long) null);
			
		}
		
		return mfList;
		
	}

	@Override
	public List<MyFoodDTO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_식품정보 ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodDTO> brList = this.select(pStr);
			pStr.close();
			return brList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MyFoodDTO findId(Long seq) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_식품정보 ";
		sql += "WHERE 일련번호 = ? ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			MyFoodDTO mfList = this.select(pStr);
			if(mfList != null && mfList.size() > 0) {
				return mfList.get(0);
			}
			return mfList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MyFoodDTO> findName(String mf_name) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM view_식품정보 ";
		sql += "WHERE 식품명 = ? ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, "mf_date");
			List<MyFoodDTO> brList = this.select(pStr);
			pStr.close();
			return brList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MyFoodDTO> findDate(String mf_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(MyFoodVO myFoodVO) {
		// TODO Auto-generated method stub
		
		String sql = " INSERT INTO tbl_myfoods( ";
		sql += " mf_seq,";
		sql += " mf_fcode,";
		sql += " mf_date,";
		sql += " mf_amt)";
		sql += " VALUES( ";
		sql += " seq_myfoods.NEXTVAL,";
		sql += "?, ?, ? )";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(0, myFoodVO.getMf_fcode());
			pStr.setString(0, myFoodVO.getMf_date());
			pStr.setFloat(0, myFoodVO.getMf_amt());
			Integer result = pStr.executeUpdate();
			pStr.close();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer update(MyFoodVO myFoodVO) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Integer delete() {
		// TODO Auto-generated method stub
		return null;
	}

}
