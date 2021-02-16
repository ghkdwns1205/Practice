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
import com.jdbc.app.entity.NotiveComment;

public class NoticeService {
	private String url ="jdbc:mysql://13.124.135.97:3306/jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String root = "cinema_pm";
	private String pw = "cinema1234";
	private String driver = "com.mysql.jdbc.Driver";
	
	  public List<Notice> getNoticeList() {
		  return getNoticeList(1,"title","");
	  }
	
	  public List<Notice> getNoticeList(int page) {
		  return getNoticeList(page,"title","");
	  }
	  
	  
	  public List<Notice> getNoticeList(int page,String field, String query) {

	      int start = 1+(page-1)*10; // 1 , 11 ,21 ,31 ,41 ,51
	      int end = page*10;  // 10 20 30 40 50
	      

	      String sql = "Select * "
				   + "from (Select @rownum:=@rownum+1 as num, n.* "
				   + "	       from(select * "
				   + "				  From notice "
				   + "				 where pubflag = 'Y' "
				   + "				   and	"+field+" like ? "
				   + "			     order by regdate desc)n, "
				   + "			   (select @rownum:=0)v)num "
				   + " Where num.id between ? and ? ";
	      
	      List<Notice> list = new ArrayList<Notice>();
	      try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         psmt.setString(1,"%"+query+"%");
	         psmt.setInt(2,start);
	         psmt.setInt(3, end);
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String writer_id = rs.getString("writer_id");
	            Date regdate = rs.getDate("regdate");
	            String content = rs.getString("content");
	            int hit = rs.getInt("hit");
	            String files = rs.getString("files");
	            String pubflag = rs.getString("pubflag");
	            boolean pub = false;
	            if(pubflag.equals("Y")) {
	            	pub = true;
	            }

	            Notice nt = new Notice(id, title, writer_id, content, regdate, hit, files, pub);
	            list.add(nt);
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return list;
	   
	}
	  
	  public List<Notice> getPubNoticeList(int page, String field, String query) {
		  int start = 1+(page-1)*10; // 1 , 11 ,21 ,31 ,41 ,51
	      int end = page*10;  // 10 20 30 40 50
	      

	      String sql = "Select * "
				   + "from (Select @rownum:=@rownum+1 as num, n.* "
				   + "	       from(select * "
				   + "				  From notice "
				   + "				 where pubflag = 'Y' "
				   + "				   and	"+field+" like ? "
				   + "			     order by regdate desc)n, "
				   + "			   (select @rownum:=0)v)num "
				   + " Where num.id between ? and ? ";
	      
	      List<Notice> list = new ArrayList<Notice>();
	      try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         psmt.setString(1,"%"+query+"%");
	         psmt.setInt(2,start);
	         psmt.setInt(3, end);
	         System.out.println("psmt : " + psmt);
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String writer_id = rs.getString("writer_id");
	            Date regdate = rs.getDate("regdate");
	            String content = rs.getString("content");
	            int hit = rs.getInt("hit");
	            String files = rs.getString("files");
	            String pubflag = rs.getString("pubflag");
	            boolean pub = false;
	            if(pubflag.equals("Y")) {
	            	pub = true;
	            }

	            Notice nt = new Notice(id, title, writer_id, content, regdate, hit, files, pub);
	            list.add(nt);
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return list;
		}

	public Notice getNoticeDetail(int id) {
		
		  String sql = "Select * from notice where id = ?";
		            Notice nt = null;
		     
		      try {
		         Class.forName(driver);
		         Connection con = DriverManager.getConnection(url, root, pw);
		         PreparedStatement psmt = con.prepareStatement(sql);
		         psmt.setInt(1,id);
		        
		         ResultSet rs = psmt.executeQuery();

		         while (rs.next()) {
		             id = rs.getInt("id");
		            String title = rs.getString("title");
		            String writer_id = rs.getString("writer_id");
		            Date regdate = rs.getTimestamp("regdate");
		            String content = rs.getString("content");
		            int hit = rs.getInt("hit");
		            String files = rs.getString("files");
		            String pubflag = rs.getString("pubflag");
		            boolean pub = false;
		            if(pubflag.equals("Y")) {
		            	pub = true;
		            }

		            nt = new Notice(id, title, writer_id, content, regdate, hit, files, pub);
		            
		         }

		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		      return nt;
		
	}
	
	public List<NotiveComment> getCommentList(int pid) {
		String sql = "select * from comment where mid =? order by regdate desc";
		
		 List<NotiveComment> list = new ArrayList<NotiveComment>();
	      try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         psmt.setInt(1,pid);
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	            int id = rs.getInt("id");
	            int mid = rs.getInt("mid");
	            String writerId = rs.getString("writer_id");
	            Date regdate = rs.getDate("regdate");
	            String comment = rs.getString("comment");

	            NotiveComment nc = new NotiveComment(id,mid, writerId, comment, regdate);
	            list.add(nc);
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return list;
		}
	
	

	public int getNoticeCount() {
		return getNoticeCount("title","");
	}
	public int getNoticeCount(String field, String query) {
		int count = 0;
		String sql = "Select count(num.id) as count "   //가상의 숫자를 만들어 역순으로 숫자정렬
	             + " from (Select @rownum:=@rownum+1 as num , n.*"
	             + "        from(select *"
	             + "               From notice"
	             + "                where "+field+" like ?"  // 검색어가 들어감
	             + "            order by regdate desc)n"
	             + "        Where (@rownum:=0)=0) num ";
		
		try {
	         Class.forName(driver);
	         Connection con = DriverManager.getConnection(url, root, pw);
	         PreparedStatement psmt = con.prepareStatement(sql);
	         psmt.setString(1,"%"+query+"%");
	         ResultSet rs = psmt.executeQuery();
	         
	         if(rs.next())
	        	 count = rs.getInt("count");
	        	 
		} catch (Exception e) {
	         e.printStackTrace();
	      }    
		return count;
	}

	public int removeNoticeAll(int[] ids) {
		 String sql = "delete from notice where id = ?";
         int result = 0;
   try {
      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, root, pw);
      for(int i = 0; i<ids.length; i++) {
    	  int id = ids[i];
      PreparedStatement psmt = con.prepareStatement(sql);
      psmt.setInt(1,id);
      psmt.executeUpdate();
      result++;
      }
   } catch (Exception e) {
      e.printStackTrace();
   }
		return result;
	}
	
	
	public int insertNotice(Notice nt) {
		int result = 0;
		
		String sql = " insert into notice(title, writer_id, content, files, pubflag) "
							+ " values(?, ?, ?, ?, ?) ";
		
		  try {
		      Class.forName(driver);
		      Connection con = DriverManager.getConnection(url, root, pw);
		      PreparedStatement psmt = con.prepareStatement(sql);
		      
		      psmt.setString(1, nt.getTitle());
		      psmt.setString(2, nt.getWriterId());
		      psmt.setString(3, nt.getContent());
		      psmt.setString(4, nt.getFiles());
		      String pub = "N";
		      if(nt.getPub()==true) {
		    	  pub = "Y";
		      }
		      psmt.setString(5, pub);
		    
		     result = psmt.executeUpdate();
		   } catch (Exception e) {
		      e.printStackTrace();
		   }
		return result;
	}
	
	public int updateNotice(Notice nt) {
		return 0;
	}
	
	public int deleteNotice(int id) {
		return 0;
	}
	
	public List<Notice>getNoticeNewList(Notice nt){
		return null;
	}
	

	public int deleteNoticeAll(int[] ids) {
		int result = 0;
		String params = "";
		
		for(int i = 0; i<ids.length; i++) {
			
			params += ids[i];
			if(i<ids.length-1)
				params += ",";
		}
		
		String sql = "delete from notice where id in("+params+") ";
		 try {
		      Class.forName(driver);
		      Connection con = DriverManager.getConnection(url, root, pw);
		     Statement st = con.createStatement();
		     result = st.executeUpdate(sql);
		   } catch (Exception e) {
		      e.printStackTrace();
		   }
		return result;
	}

	public void countNoticeHit(int id) {
		
		String sql = "update notice set hit=hit+1 where id = ? ";
		
		 try {
		      Class.forName(driver);
		      Connection con = DriverManager.getConnection(url, root, pw);
		     PreparedStatement psmt = con.prepareStatement(sql);
		     psmt.setInt(1, id);
		     psmt.executeUpdate();
		   } catch (Exception e) {
		      e.printStackTrace();
		   }
	}

	public int insertNoticeComment(NotiveComment nc) {
		int result = 0;
		String sql = "insert into comment( mid, writer_id, comment) values(?, ?, ?)";
		
		 try {
		      Class.forName(driver);
		      Connection con = DriverManager.getConnection(url, root, pw);
		     PreparedStatement psmt = con.prepareStatement(sql);
		     psmt.setInt(1, nc.getMid());
		     psmt.setString(2, nc.getWriterId());
		     psmt.setString(3, nc.getComment());
		     result = psmt.executeUpdate();
		   } catch (Exception e) {
		      e.printStackTrace();
		   }
		 
		return result;
	}

	public int getNoticeCommentCount(int id) {
		int count = 0;
		String sql = "select count(id) as count from comment where mid =? ";
		
		try {
			  Class.forName(driver);
		      Connection con = DriverManager.getConnection(url, root, pw);
		      PreparedStatement psmt = con.prepareStatement(sql);
		      psmt.setInt(1,id);
		      ResultSet rs = psmt.executeQuery();
		      
		      if(rs.next())
		    	  count = rs.getInt("count");
		      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
