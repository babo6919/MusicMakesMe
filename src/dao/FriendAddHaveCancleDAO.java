package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.FriendStateBean;

public class FriendAddHaveCancleDAO {
	public static FriendAddHaveCancleDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private FriendAddHaveCancleDAO() {
		
	}
	
	public static FriendAddHaveCancleDAO getInstance() {
		if(instance==null) {
			instance = new FriendAddHaveCancleDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}

public int FriendaddCancle(String ID, String Delete_Id) {
	String sql="DELETE FROM FRIEND_STATE WHERE ID=? AND FRIEND_ID=?"; 
	int AddCancle_Count=0;
	String id=Delete_Id;
	String friend_id=ID;
	try {
	pstmt=con.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, friend_id);
	AddCancle_Count = pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("딜리트 에러 :"+ e);
	}finally {
		try {
			close(pstmt);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("딜리트 에러 :"+ e);
		}
	}
	return AddCancle_Count;
}
}
