package com.callor.guest.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.guest.config.DBInfo;
import com.callor.guest.model.GuestBookVO;
import com.callor.guest.service.GuestBookService;
import com.callor.guest.service.impl.GuestBookServiceImpl;

@WebServlet("/guest/*")
public class GuestBookController extends HttpServlet {

	private static final long serialVersionUID = 8809751963966366668L;

	protected GuestBookService gbService;

	public GuestBookController() {
		gbService = new GuestBookServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();
		if (subPath.equals("/view")) {

			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);
			GuestBookVO gbVO = gbService.findById(gb_seq);

			req.setAttribute("GB", gbVO);
			req.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
		} else if (subPath.equals("/insert")) {

			GuestBookVO gbVO = new GuestBookVO();

			// 글쓰기를 시작할때 자동으로
			// 현재 날짜와 시각을 만들어주기
			// java 1.7이하서도 모두 사용할수 있는 방법
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());

			gbVO.setGb_seq(0L);
			gbVO.setGb_date(sd.format(date));
			gbVO.setGb_time(st.format(date));

			req.setAttribute("GB", gbVO);
			RequestForwardController.forword(req, resp, "write");
		} else if (subPath.equals("/delete")) {

			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);

			System.out.println("SEQ:" + gb_seq);
			gbService.delete(gb_seq);
			resp.sendRedirect("/guest/");

		} else if (subPath.equals("/update")) {

			// seq값으로 데이터를 1개 찾아서
			// vo에 담고
			// writer.jsp에 넘겨서 보여주기
			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);

			GuestBookVO gbVO = gbService.findById(gb_seq);
			req.setAttribute("GB", gbVO);
			RequestForwardController.forword(req, resp, "write");

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String subPath = req.getPathInfo();

		String gb_date = req.getParameter(DBInfo.gb_date);

		String gb_time = req.getParameter(DBInfo.gb_time);
		String gb_writer = req.getParameter(DBInfo.gb_writer);

		String gb_email = req.getParameter(DBInfo.gb_email);

		String gb_password = req.getParameter(DBInfo.gb_password);

		String gb_content = req.getParameter(DBInfo.gb_content);

		GuestBookVO gbVO = new GuestBookVO();
		gbVO.setGb_date(gb_date);
		gbVO.setGb_time(gb_time);
		gbVO.setGb_writer(gb_writer);
		gbVO.setGb_email(gb_email);
		gbVO.setGb_password(gb_password);
		gbVO.setGb_content(gb_content);
		System.out.println(gbVO.toString());

		if (subPath.equals("/insert")) {
			gbService.insert(gbVO);
			resp.sendRedirect("/guest/");
		} else if (subPath.equals("/update")) {

			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);

			gbVO.setGb_seq(gb_seq);
			gbService.update(gbVO);
			resp.sendRedirect("/guest/");

		}
	}

}
