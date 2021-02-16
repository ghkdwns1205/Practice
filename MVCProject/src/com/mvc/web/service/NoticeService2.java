package com.mvc.web.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdbc.app.entity.Notice;


public class NoticeService2 {
	public Notice getNoticeList(){
	Notice ntc = new Notice();
	 String url ="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	 String root = "root";
	 String pw = "soaksdkady1!";
	 String driver = "com.mysql.jdbc.Driver";
	 String sql = "Select * from notice where id = 3";
	      
	      try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         ResultSet rs = psmt.executeQuery();

	         rs.next();
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String writer_id = rs.getString("writer_id");
	            Date regdate = rs.getDate("regdate");
	            String content = rs.getString("content");
	            int hit = rs.getInt("hit");
	            String files = rs.getString("files");

	            Notice nt = new Notice(id, title, writer_id, content, regdate, hit, files);
	            ntc = nt;
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return ntc;
	}
}
