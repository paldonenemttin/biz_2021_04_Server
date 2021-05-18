package com.callor.guest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.guest.model.GuestBookVO;
import com.callor.guest.service.GuestBookService;
import com.callor.guest.service.impl.GuestBookServiceImpl;

@WebServlet("/")
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = -3449187460090115340L;
	
	protected GuestBookService gbService;
	
	public HomeController() {
		// TODO Auto-generated constructor stub
		gbService = new GuestBookServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<GuestBookVO> gbList = gbService.selectAll();
		req.setAttribute("GBLIST", gbList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp")
		.forward(req, resp);
	}
	
	
	
	

}
