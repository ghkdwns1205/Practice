package com.mvc.web.controller.admin;

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
	

	@WebServlet("/admin/board/notice/list1")
	public class NoticeDetailController extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			
			NoticeService ns = new NoticeService();
			Notice nts = ns.getNoticeDetail(id);
			
			
			req.setAttribute("nt", nts);
			req.getRequestDispatcher("/WEB-INF/view/notice/detail1.jsp").forward(req, res);
		}
	}

