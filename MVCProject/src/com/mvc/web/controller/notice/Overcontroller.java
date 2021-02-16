package com.mvc.web.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.app.entity.Overwatch;
import com.mvc.web.service.NoticeService;
import com.mvc.web.service.OverService;

@WebServlet("/over")
public class Overcontroller extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 OverService os = new OverService();
		 int page = 1;
		 String page_ = req.getParameter("p");
		 if(page_ !=null && !page_.equals("")) {
			 page = Integer.parseInt(page_);
		 }
		 List<Overwatch> list =os.getlist(page);
		 
		 int count = 0;
			count = os.getOverCount();
			 System.out.println(count);
		req.setAttribute("over", list);
		req.setAttribute("count", count);
		req.getRequestDispatcher("WEB-INF/view/Overwatch/overlist.jsp").forward(req, resp);
	}
}
