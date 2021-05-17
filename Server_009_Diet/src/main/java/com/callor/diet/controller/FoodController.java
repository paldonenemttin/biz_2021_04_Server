package com.callor.diet.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.MyFoodVO;
import com.callor.diet.service.FoodService;
import com.callor.diet.service.MyFoodService;
import com.callor.diet.service.impl.FoodServiceImplV1;
import com.callor.diet.service.impl.MyFoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet{

	private static final long serialVersionUID = 5430871336219122803L;
	protected FoodService fdService;
	protected MyFoodService mfService;
	
	public FoodController() {
		fdService = new FoodServiceImplV1();
		mfService = new MyFoodServiceImplV1();
	}

	// anchor link를 클릭했을때 처리할 method
	// a tag <a herf>
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청주소에 / food 다음에 오는 
		//                   sub 요청 문자열을 추출
		// /food/search라고 요청을 보내면
		//                  /search 문자열 추출
		String subPath = req.getPathInfo();
		
		if(subPath == null || subPath.equals("")) {
			
			System.out.println("요청 subPath 없음");
			
		} else if ( subPath.equals("/search")) {
			// 식품검색화면 보여주기
			ReqController.forward(req, resp, "search");
			
		} else if( subPath.equals("/insert")) {
			
			// 식품을 선택하여 식품 코드를 전달 받은 후
			// 섭취정보를 입력하기 위한 화면을 보여주기
			// 식품 코드, 식품 이름
			// 전달받은 식품 코드로 식품정보를 조회하여
			// insert,.jsp에 전달하기
			String fd_code = req.getParameter("fd_code");
			
			FoodDTO foodDTO = fdService.findById(fd_code);
			req.setAttribute("FOOD", foodDTO);
			
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
			String today= sd.format(date);
			
			req.setAttribute("TODAY", today);
			
			ReqController.forward(req, resp, "insert");
			
		}
	}

	// form에서 input Box에 입력한 데이터를 전송했을때
	// method를 Post로 지정하면 처리할 함수
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		
		if(subPath == null || subPath.equals("")) {
			System.out.println("subPath가 없음");
		} else if(subPath.equals("/search")) {
			
			// from에 입력된 데이터를 추출하고(파라메터를 get)
			String f_name = req.getParameter("f_name");
			
			// DB에서 조회하여 다시 WEb에 보여주기
			List<FoodDTO> foodList = fdService.findByFname(f_name);
			
			req.setAttribute("FOODS", foodList);
			ReqController.forward(req, resp, "search");
			
		} else if(subPath.equals("/insert")) {
			String strFcode = req.getParameter("mf_code");
			String strDate = req.getParameter("mf_date");
			String strAmt = req.getParameter("mf_amt");
			
			MyFoodVO myfoodVO = new MyFoodVO();
			myfoodVO.setMf_fcode(strFcode);
			myfoodVO.setMf_date(strDate);
			myfoodVO.setMf_amt(Float.valueOf(strAmt));
			 
			int result = mfService.insert(myfoodVO);
			if(result > 0) {
				System.out.println("insert 성공");
				resp.sendRedirect("/diet");
			} else {
				System.out.println("insert 실패");
			}
		}
	}
	
	

}
