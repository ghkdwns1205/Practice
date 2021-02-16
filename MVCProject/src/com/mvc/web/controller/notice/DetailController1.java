package com.mvc.web.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.app.entity.Notice;
import com.jdbc.app.entity.NotiveComment;
import com.mvc.web.service.NoticeService;

@WebServlet("/notice/detail")
public class DetailController1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		
		NoticeService ns = new NoticeService();
		ns.countNoticeHit(id);  // hit 카운트
		Notice nt = ns.getNoticeDetail(id);  // 페이지 호출
		
		NotiveComment nc = new NotiveComment();
		
		int comCount =0;
		comCount = ns.getNoticeCommentCount(id);
		if(comCount != 0 ) {
			List<NotiveComment> list = ns.getCommentList(id);
	
				
			  req.setAttribute("comList", list);
			  
		      req.setAttribute("nt", nt);
//		      req.setAttribute("id", id);
		     
	}
		req.setAttribute("count", comCount);
		req.getRequestDispatcher("/WEB-INF/view/notice/detail1.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String comment = req.getParameter("comment");
		String pid = req.getParameter("pageID");
		int pageID = Integer.parseInt(pid);
		String writerID = req.getParameter("writerId");
		int result = 0;
		System.out.println("pid : " + pageID);
		System.out.println("wID : " + writerID);
		System.out.println("comment : " + comment);
		
		NoticeService ns = new NoticeService();
		NotiveComment nc = new NotiveComment();
		
		nc.setMid(pageID);
		nc.setComment(comment);
		nc.setWriterId(writerID);
		
		
		
		result = ns.insertNoticeComment(nc);
		System.out.println("결과:" +result);
		//resp.sendRedirect("detail");
		resp.sendRedirect("detail?id="+pid);
	}
}
