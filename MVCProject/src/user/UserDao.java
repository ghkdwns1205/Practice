package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;


public class UserDao {
	
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public UserDao() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/study?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String dbID = "lain";
			String dbPass = "12345";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL,dbID,dbPass);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int login (String userID, String userPASS) {  //로그인용
		String SQL = "SELECT userPass FROM USER WHERE userID = ? ";
		
		try {
			psmt = con.prepareStatement(SQL);
			psmt.setString(1, userID);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPASS)) {
				return 1;  //값 불러오기 성공 로그인성공
			}else {
				return 0;   //없음ㄴ 비밀번호 틀림
			}
		}
		return -1;  //접속오류
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;  //데이터베이스오류
	}


public int join(User user) {
	String SQL = "INSERT INTO USER VALUES(?,?,?,?,?)";
	try {
		psmt = con.prepareStatement(SQL);
		psmt.setString(1, user.getUserID());
		psmt.setString(2, user.getUserPASS());
		psmt.setString(3, user.getUserName());
		psmt.setString(4, user.getUserGender());
		psmt.setString(5, user.getUserEmail());
		return psmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}return -1;
}

}