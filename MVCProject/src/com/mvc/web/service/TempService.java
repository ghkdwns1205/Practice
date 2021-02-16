package com.mvc.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdbc.app.entity.Notice;
import com.jdbc.app.entity.Temp;

public class TempService {

	private String url ="jdbc:mysql://localhost:3306/home_work?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String root = "root";
	private String pw = "soaksdkady1!";
	private String driver = "com.mysql.jdbc.Driver";
	
	public Temp gettempdata(String date, String locid) {
		 String sql = "Select * from temp where date = ? and locid = ?"; 
		 
		 Temp tp = null;
//	      List<Notice> list = new ArrayList<Notice>();
	      try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         psmt.setString(1,date);
	         psmt.setString(2, locid);
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	           String date1 = rs.getString("date");
	           int temp = rs.getInt("temp");
	           int locid1 = rs.getInt("locid");
	            String writer = rs.getString("writer");

	            tp = new Temp(date1, temp, locid1, writer);
//	            list.add(nt);
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return tp;
	}
	
	
	
}
