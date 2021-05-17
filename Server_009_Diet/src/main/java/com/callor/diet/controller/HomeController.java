package com.callor.diet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.MyFoodDTO;
import com.callor.diet.service.MyFoodService;
import com.callor.diet.service.impl.MyFoodServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -953531494441799347L;

	protected MyFoodService mfService;
	
	public HomeController() {
		// TODO Auto-generated constructor stub
		
		mfService = new MyFoodServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
		List<MyFoodDTO> mfList = mfService.selectAll();
		req.setAttribute("MFOODS", mfList);
		
		ReqController.forward(req, resp, "home");
		
		String mf_date = req.getParameter("mf_date");
		List<MyFoodDTO> mfList2 = ArrayList<MyFoodDTO>;
		
	}
	
	

}
