package web.mvc.web.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class MVCTestController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String result = "안녕하세요~~~";
		
		req.setAttribute("result", result);
		
		String number = "";
		req.setAttribute("b", number);
		
		
		RequestDispatcher dis =req.getRequestDispatcher("WEB-INF/view/Test/MVCTest.jsp");
		dis.forward(req, res);
//		res.sendRedirect("WEB-INF/view/Test/MVCTest.jsp");
	}
}
