package com.mvc.web.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.app.entity.User;
import com.mvc.web.service.UserService;

@WebServlet("/userlist")
public class UserListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		UserService us = new UserService();
		User user = us.getuserlist(name);
		System.out.println(name);
		
		req.setAttribute("user", user);
		req.getRequestDispatcher("WEB-INF/view/notice/Userlist.jsp").forward(req, resp);
		
	}
}
