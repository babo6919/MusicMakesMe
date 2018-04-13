package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.FriendStateBean;

public class FriendDAO {
	public static FriendDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private FriendDAO() {
		
	}
	
	public static FriendDAO getInstance() {
		if(instance==null) {
			instance = new FriendDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	
	
	public int insertFriend(FriendStateBean friend , String ID , String USER_ID) {
		String sql = "INSERT all INTO FRIEND_STATE VALUES(?,?)" + 
				"select id from member where id=? and not exists" + 
				"(SELECT * FROM FRIEND_STATE WHERE ID=? and FRIEND_ID=?)";
		int insertCount=0;
		try {
			pstmt = con.prepareStatement(sql);
			//sql ?에 들어갈 부분 순차적으로 작성
			pstmt.setString(1, ID);
			pstmt.setString(2, USER_ID);
			pstmt.setString(3, ID);
			pstmt.setString(4, ID);
			pstmt.setString(5, USER_ID);
			//쿼리를 실행
			insertCount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("친구신청SQL 에러 :"+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
}
