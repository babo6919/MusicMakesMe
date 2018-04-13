package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDeleteDAO {
		public static MemberDeleteDAO instance;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		private MemberDeleteDAO() {}
		public static MemberDeleteDAO getInstance() {
			if(instance == null) {
				instance = new MemberDeleteDAO();
			}return instance;
		}
		public void setConnection(Connection con) {
			this.con=con;
		}
	public int DeleteMember(String Delete_Id) {
		String sql="DELETE FROM MEMBER WHERE ID=?"; 
		int Delete_Count=0;
		String id=Delete_Id;
		try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		Delete_Count = pstmt.executeUpdate();
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
		return Delete_Count;
	}

public int DrawMember(String ID) {
	String sql="DELETE FROM MEMBER WHERE ID=?"; 
	int Draw_Count=0;
	String id=ID;
	try {
	pstmt=con.prepareStatement(sql);
	pstmt.setString(1, id);
	Draw_Count = pstmt.executeUpdate();
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
	return Draw_Count;
}
}
