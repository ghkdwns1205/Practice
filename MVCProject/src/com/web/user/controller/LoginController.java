package com.web.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import user.UserDao;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("userID");
		String pass = req.getParameter("userPASS");
	
		
		UserDao ud = new UserDao();
		
		int result = ud.login(id, pass);
	
		if(id !=null){   //이미 로그인 했으면 다시 로그인 할 수 없게
			resp.sendRedirect("main");
		       
		}
		
		if(result==1){   //로그인 성공
			resp.sendRedirect("main");
		}
		else if(result==0){//패스워드 잘못됨
			resp.sendRedirect("login");
			
		
		}else if(result == -1){//가입되지 않은 아이디
			
			resp.sendRedirect("login");
			
		}else if(result == -2){//db오류
			
			resp.sendRedirect("login");
			
		}
		
		
		
		}
}
