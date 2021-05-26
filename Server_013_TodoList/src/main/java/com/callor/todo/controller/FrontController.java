package com.callor.todo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.command.TodoCommend;
import com.callor.todo.command.TodoCommendImplV1;
import com.callor.todo.command.HomeConmmendImplV1;

@WebServlet("/")
public class FrontController extends HttpServlet{
	
	protected Map<String, TodoCommend> commends;
	
	// FrontConroller가 최초 호출될때
	// 한번 실행되어서
	// 여러 변수 등을 초기화 하는 코드
	@Override
	public void init(ServletConfig config) throws ServletException {
		commends = new HashMap<String, TodoCommend>();
		
		// 만약 rootPath/ 로 요청이 오면
		// HomeCommendImplV1 객체를 사용하여 요청을 처리하기 위한 준비
		commends.put("/", new HomeConmmendImplV1());
		
		// 만약 rootPath/insert로 요청이 오면
		// TodoCommendImplV1객체를 사용하여 요청을 처리하기 위한 준비
		commends.put("/insert", new TodoCommendImplV1());
	}
	
	// doGet() doPost()로 분리하여 요청을 처리하던 방식을
	// 한개의 method에서 동시에 처리하기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// Web에서 요청한 path가져오기
		String urlPath = req.getRequestURI();
		String path = urlPath.substring(req.getContextPath().length());
		
		// req된 URI중에서
		// 실제 subpath 부분을 사용하여
		// 처리할 객체를 Map으로부터 추출
		TodoCommend subCommend = commends.get(path);
		if(subCommend != null) {
			
			// 각 Commend객체의 excute() method에게
			// 
			subCommend.execute(req, resp);
		}
	}

	
	
	

}
