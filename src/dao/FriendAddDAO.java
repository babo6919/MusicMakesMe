package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.FriendStateBean;

public class FriendAddDAO {
	public static FriendAddDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private FriendAddDAO() {
		
	}
	
	public static FriendAddDAO getInstance() {
		if(instance==null) {
			instance = new FriendAddDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	
	
	public int insertFriend(FriendStateBean friend , String ID , String USER_ID) {
		String sql = "insert ALL" + 
				"    INTO FRIEND_LIST values (?,?)" + 
				"    INTO FRIEND_LIST VALUES(?,?)" + 
				"    SELECT * FROM member where id=? and NOT EXISTS" + 
				"	(SELECT * FROM FRIEND_LIST where Friend_id=?)";
		int insertCount=0;
		try {
			pstmt = con.prepareStatement(sql);
			//sql ?에 들어갈 부분 순차적으로 작성
			pstmt.setString(1, ID);
			pstmt.setString(2, USER_ID);
			pstmt.setString(3, USER_ID);
			pstmt.setString(4, ID);
			pstmt.setString(5, ID);
			pstmt.setString(6, USER_ID);
			//쿼리를 실행
			insertCount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("joinSQL 에러 :"+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
}
