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

	@WebServlet("/admin/board/notice/Index")
	public class IndexController extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			NoticeService ns = new NoticeService();
			
			String page_ = req.getParameter("p");
			String field_ = req.getParameter("f");
			String query_ = req.getParameter("q");
			
			//매개변수 초기화
			int page= 1;
			String field = "title";
			String query = "";
			
			//null 값 보완
			
			if(page_ != null && !page_.equals("") ) {
				page = Integer.parseInt(page_);
			}
			
			if(field_ != null && !field_.equals("")) {
				field = field_;
			}
			
			if(query_ != null && !query_.equals("")) {
				query = query_;
			}
			
			
			
			
			List<Notice> list = ns.getNoticeList(page,field,query);
			
			int count = 0;
			count = ns.getNoticeCount(field,query);
			System.out.println(count);
			
			      req.setAttribute("list", list);  // list 보내기
			      req.setAttribute("count", count); // 조회 된 목록 갯수 count 보내기
			      req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/Index.jsp").forward(req, res);
		}
	}