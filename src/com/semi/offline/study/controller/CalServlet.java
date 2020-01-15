package com.semi.offline.study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.semi.offline.study.dao.TbStudyDao;
import com.semi.offline.study.dao.Util;
import com.semi.offline.study.dto.TbStudyDto;

@WebServlet("/calcontroller.do")
public class CalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		TbStudyDao dao = new TbStudyDao();
		
		if(command.equals("calendar")) {
			response.sendRedirect("Profile_Cal.jsp");
		
		}else if(command.equals("callist")) {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			
			String yyyyMMdd = year + Util.isTwo(month) + Util.isTwo(date);
			System.out.println("yyyyMMdd : " + yyyyMMdd);
			
			List<TbStudyDto> list = dao.getCalList("kh", yyyyMMdd);
			System.out.println("list :" + list);
			
			request.setAttribute("list", list);
			dispatch("callist.jsp", request, response);
		}
			
		
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doGet(request,response);
	}

}
