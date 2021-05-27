package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.callor.todo.config.DBContract;
import com.callor.todo.config.DBInfo;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService {

	protected Connection dbConn;

	public TodoServiceImplV1() {
		// TODO Auto-generated constructor stub
		dbConn = DBContract.getDbConn();
	}

	/*
	 * 객체, Entity, Replation DataBase를 만들고 Table을 생선한 후 Insert 수행하면 실제상황의 데이터가
	 * Table에 저장된다 INSERT를 수행 한 후 SELECT를 수행하여 조회를 할 수 있는 데이터들
	 * 
	 * 메타데이터(meta data) 생성한 Database, table, sequense, view ...이 어떤 구조 만들어져 있는가 등의
	 * 정보를 메타데이터라 한다 ex) myDB하는 database에 몇개의 table이 있는다 등의 정보를 알고 싶으면 myDB 메타데이터의
	 * 정보를
	 */
	protected List<Map<String, Object>> select(ResultSet rSet) throws SQLException {
		// ResultSet으로 부터 메타데이터 추출하여
		// 조회를 수행한 결과고 전달받은
		// Table(tbl_todolist)
		// 에 칼럼이 몇개 있는지 확인

		ResultSetMetaData md = rSet.getMetaData();
		int columns = md.getColumnCount();

		List<Map<String, Object>> tdList = new ArrayList<Map<String, Object>>();

		// rSet(selecte된 데이터)를 한라인씩 추출하고
		while (rSet.next()) {
			// 각 데이터의 칼럼을 index를 기준ㅇ츠로
			// 값을 추출해보기
			Map<String, Object> tdVO = new HashMap<String, Object>();
			for (int i = 0; i < columns; i++) {
				// 메타데이터의 index위치의 칼럼이름 가져오기
				String colName = md.getColumnName(i + 1);
				// ResultSet의 index위치의 실제 데이터 가져오기
				Object objdata = rSet.getObject(i + 1);
				// 칼럼데이터를 VO에 pull
				tdVO.put(colName, objdata);
			}
			tdList.add(tdVO);
		}
		return tdList;
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_todolist ";
		sql += " ORDER BY td_edate, td_sdate, td_stime ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);

			ResultSet rSet = pStr.executeQuery();

			List<Map<String, Object>> tdList = this.select(rSet);
			rSet.close();
			pStr.close();
			return tdList;

//				  ResultSetMetaData md = rSet.getMetaData(); 
//				  int count = md.getColumnCount();
//				
//				System.out.println("=".repeat(50));
//				for(int i = 0 ;i < count ; i++) {
//					System.out.print(md.getColumnName(i + 1) + "\t");
//				}
//				System.out.println();
//				
//				while(rSet.next()) {
//					//System.out.println(rSet.getString("td_sdate") + "\t");
//					//System.out.println(rSet.getString("td_stime") + "\t");
//					//System.out.println(rSet.getString("td_doit") "\n");
//					for(int i =0; i < count ; i++) {
//						System.out.print(rSet.getString(i+1) + "\t");
//					}
//					System.out.println();
//				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Map<String, Object> findById(Long td_seq) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tbl_todolist";
		sql += " WHERE td_seq = ?";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, td_seq);

			ResultSet rSet = pStr.executeQuery();
			List<Map<String, Object>> tdList = this.select(rSet);
			if (tdList != null && tdList.size() > 0) {
				return tdList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> findBySDate(String td_sdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findByDoit(String td_doit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(Map<String, Object> tdVO) {
		// TODO todoList 등록하기

		// 현재 날짜 가져오기
		Date Date = new Date(System.currentTimeMillis());

		// 날짜를 문자열화 하기 위한 보조 클래스
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat td = new SimpleDateFormat("HH:mm:ss");

		String curDate = sd.format(Date);
		String curTime = td.format(Date);

		// tdVO에 2개의 칼럼을 추가하고
		// 데이터 추가
		tdVO.put(DBInfo.td_sdate, curDate);
		tdVO.put(DBInfo.td_stime, curTime);

		String sql = " INSERT INTO tbl_todolist ( ";
		sql += " td_sdate,";
		sql += " td_stime,";
		sql += " td_doit)";
		sql += "VALUES(?,?,?)";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, tdVO.get(DBInfo.td_sdate));
			pStr.setObject(2, tdVO.get(DBInfo.td_stime));
			pStr.setObject(3, tdVO.get(DBInfo.td_doit));

			Integer ret = pStr.executeUpdate();
			pStr.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer update(Map<String, Object> tdVO) {
		// TODO Auto-generated method stub
		
		// 변수에 sql 명령 입력
		String sql = " UPDATE tbl_todolist SET ";
		sql += " td_sdate = ?, ";
		sql += " td_stime = ?, ";
		sql += " td_doit = ?, ";
		sql += " td_edate = ?, ";
		sql += " td_etime = ? ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, tdVO.get(DBInfo.td_sdate));
			pStr.setObject(2, tdVO.get(DBInfo.td_stime));
			pStr.setObject(3, tdVO.get(DBInfo.td_doit));
			pStr.setObject(4, tdVO.get(DBInfo.td_edate));
			pStr.setObject(5, tdVO.get(DBInfo.td_etime));
			pStr.setObject(6, tdVO.get(DBInfo.td_seq));
			
			Integer ret = pStr.executeUpdate();
			pStr.close();
			return ret;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
