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

@WebServlet("/write")
public class OverWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OverService os = new OverService();
		int max = os.getmaxcount();
		int max1 = os.getmaxcount1();
		
		List<Overwatch> list = os.getAddLocation(max,max1);
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/view/Overwatch/OverWrite.jsp").forward(req, resp);
	}
}
