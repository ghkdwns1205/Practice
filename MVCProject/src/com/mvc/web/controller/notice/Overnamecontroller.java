package com.mvc.web.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.app.entity.Overwatch;
import com.mvc.web.service.OverService;

@WebServlet("/find")
public class Overnamecontroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OverService os = new OverService();
		
		String name = req.getParameter("name");
		
		Overwatch ow = os.getfind(name);
		
		req.setAttribute("find", ow);
		req.getRequestDispatcher("WEB-INF/view/Overwatch/OverFind.jsp").forward(req, resp);
	}
}
