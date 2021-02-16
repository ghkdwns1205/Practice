package com.mvc.web.controller.notice;

	import java.io.IOException;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.jdbc.app.entity.Notice;
	import com.mvc.web.service.NoticeService;
	import com.mvc.web.service.NoticeService1;
	

	@WebServlet("/list1")
	public class NoticeDetailController extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			
			
			NoticeService1 ns = new NoticeService1();
			Notice nts = ns.getNoticeList();
			
			
			      req.setAttribute("nts", nts);
			      req.getRequestDispatcher("/WEB-INF/view/notice/NoticeDetail.jsp").forward(req, res);
		}
	}

