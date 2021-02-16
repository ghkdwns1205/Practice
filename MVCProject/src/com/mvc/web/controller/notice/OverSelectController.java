package com.mvc.web.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.app.entity.Overwatch;
import com.mvc.web.service.OverService;

@WebServlet("/select")
public class OverSelectController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println("id"+id);
		String c[]=req.getParameterValues("c");
		int seq  [] = new int[c.length];
		
		for(int i = 0; i<c.length; i++) {
			
			seq[i] =Integer.parseInt(c[i]);
		}
		
		OverService os = new OverService();
		int result = os.removeAll(seq);
		
		resp.sendRedirect("select");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		OverService os = new OverService();
		 List<Overwatch> list =os.getselect(id);
		 
		 req.setAttribute("id", list);
		 req.getRequestDispatcher("WEB-INF/view/Overwatch/Overselect.jsp").forward(req, resp);
	}
}
