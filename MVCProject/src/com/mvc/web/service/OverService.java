package com.mvc.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdbc.app.entity.Notice;
import com.jdbc.app.entity.Overwatch;
import com.mysql.cj.protocol.Resultset;

public class OverService {

	private String url ="jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String root = "root";
	private String pw = "soaksdkady1!";
	private String driver = "com.mysql.jdbc.Driver";
	
	public List<Overwatch> getlist(int page) {
		System.out.println(page);
		 int start = 1+(page-1)*7; // 1 , 11 ,21 ,31 ,41 ,51
	      int end = page*7;  // 10 20 30 40 50
	      System.out.println(start);
	      System.out.println(end);
	      
		 String sql = "Select *"   //가상의 숫자를 만들어 역순으로 숫자정렬
	             + " from (Select @rownum:=@rownum+1 as num , n.*"
	             + "        from(select loc.locname as location, s.regdate as date, u.id, u.name, s.enemy, s.content, s.seq as seq from location loc, user u, score s where loc.id = s.seq and u.id = s.hiter)n"
	             + "        Where (@rownum:=0)=0) num "
	             + " Where num.num between ? and ? ";
	             
		System.out.println(sql);
		 List<Overwatch> list = new ArrayList<Overwatch>();
		 try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         psmt.setInt(1,start);
	         psmt.setInt(2, end);
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	            String location = rs.getString("location");
	            Date date = rs.getDate("date");
	            String id = rs.getString("id");
	            String name = rs.getString("name");
	            String enemy = rs.getString("enemy");
	            String content = rs.getString("content");
	            int seq = rs.getInt("seq");

	            Overwatch ow = new Overwatch(location, date, id, name, enemy, content,seq);
	            list.add(ow);
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return list;
		
	}
	public Overwatch getfind(String name) {
		
		String sql = "select * from user where name like ?"; 
	             
		System.out.println(sql);
		Overwatch ow = null;
		 try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         psmt.setString(1, "%"+name+"%");
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	            String id = rs.getString("id");
	            int pass = rs.getInt("pass");
	            String name1 = rs.getString("name");
	            String email = rs.getString("email");
	            String flag = rs.getString("flag");

	             ow = new Overwatch(id, pass, name1, email, flag);
	            
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return ow;
	}
	public List<Overwatch> getselect(String id) {
		String sql = "select * from (select loc.locname as location, s.regdate as date, u.id, u.name, s.enemy, s.content, s.seq as seq "
				+ " from location loc, user u, score s where loc.id = s.seq and u.id = s.hiter)A "
				+ " where a.id = ?"; 
	             
		System.out.println(sql);
		
		 List<Overwatch> list = new ArrayList<Overwatch>();
		 try {
			 Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         psmt.setString(1, id);
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
		            String location = rs.getString("location");
		            Date date = rs.getDate("date");
		            String id2 = rs.getString("id");
		            String name3 = rs.getString("name");
		            String enemy = rs.getString("enemy");
		            String content = rs.getString("content");
		            int seq = rs.getInt("seq");

	            Overwatch oo = new Overwatch(location, date, id2, name3, enemy, content,seq);
	            list.add(oo);
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return list;
	}
	public int getOverCount() {
		int count = 0;
		 String sql = "Select count(num.id) as count"   //가상의 숫자를 만들어 역순으로 숫자정렬
	             + " from (Select @rownum:=@rownum+1 as num , n.*"
	             + "        from(select loc.locname as location, s.regdate as date, u.id, u.name, s.enemy, s.content from location loc, user u, score s where loc.id = s.seq and u.id = s.hiter)n"
	             + "        Where (@rownum:=0)=0) num " ;
		 try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql);
	         if(rs.next())
	        	 count = rs.getInt("count");
	        	 
		} catch (Exception e) {
	         e.printStackTrace();
	      }    
		return count;
	}
	public int removeAll(int[] seq) {
		 String sql = "delete from score where seq = ?";
         int result = 0;
   try {
      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, root, pw);
      for(int i = 0; i<seq.length; i++) {
    	  	
      PreparedStatement psmt = con.prepareStatement(sql);
      psmt.setInt(1,seq[i]);
      psmt.executeUpdate();
      result++;
      }
   } catch (Exception e) {
      e.printStackTrace();
   }
		return result;
	}
	public List<Overwatch> getAddLocation(int max, int max1) {
		
		String sql = "select * from location where id between ? and ? ";
        List<Overwatch> list = new ArrayList<Overwatch>();
   try {
      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, root, pw);
      PreparedStatement psmt = con.prepareStatement(sql);
      psmt.setInt(1, max+1);
      psmt.setInt(2, max1);
      System.out.println(max);
      System.out.println(max1);
      ResultSet rs = psmt.executeQuery();
      
      while(rs.next()) {
    	  String location = rs.getString("locname");
    	  Overwatch ow = new Overwatch(location);
    	  list.add(ow);
      }
      
   } catch (Exception e) {
      e.printStackTrace();
   }
		return list;
	}
	public int getmaxcount() {
		int max = 0;
		String sql = "SELECT MAX(locid)as max FROM score";
		try {
		Class.forName(driver);
	    Connection con = DriverManager.getConnection(url, root, pw);
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(sql);
	    rs.next();
	    max = rs.getInt("max");
	    System.out.println(max);
	      
	      
	   } catch (Exception e) {
	      e.printStackTrace();
	   }
		return max;
	}
	public int getmaxcount1() {
		int max1 = 0;
		String sql = "SELECT MAX(id)as max FROM location";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, root, pw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			max1 = rs.getInt("max");
			System.out.println("max1 값 : " + max1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return max1;
	}
}
