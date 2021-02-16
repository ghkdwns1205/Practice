package com.mvc.web.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.app.entity.Temp;
import com.mvc.web.service.TempService;

@WebServlet("/templist")
public class TempListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
//		int id = Integer.parseInt(req.getParameter("id"));
		String date = req.getParameter("date");
		String locid = req.getParameter("locid");
		System.out.println(date);
		System.out.println(locid);
		TempService ts = new TempService();
		Temp tp = ts.gettempdata(date,locid);
		
		 req.setAttribute("tp", tp);
	      req.getRequestDispatcher("WEB-INF/view/notice/Templist.jsp").forward(req, res);
	
		
	}
}
