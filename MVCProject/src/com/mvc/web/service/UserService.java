package com.mvc.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.jdbc.app.entity.Temp;
import com.jdbc.app.entity.User;

public class UserService {

	private String url ="jdbc:mysql://localhost:3306/home_work?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String root = "root";
	private String pw = "soaksdkady1!";
	private String driver = "com.mysql.jdbc.Driver";
	
	public User getuserlist(String name) {
		
		String sql = "Select * from user where name = ?"; 
		 
		User user = null;
//	      List<Notice> list = new ArrayList<Notice>();
	      try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         psmt.setString(1,name);
	       
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	        	 int seq = rs.getInt("seq");
	           String id = rs.getString("id");
	           String name1 = rs.getString("name");
	           String email = rs.getString("email");
	           String hp = rs.getString("hp");
	           Date regdate = rs.getDate("regdate");
	            String flag = rs.getString("flag");

	            user = new User(seq, id, name1, email, hp, regdate, flag );
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return user;
	}
	
}

