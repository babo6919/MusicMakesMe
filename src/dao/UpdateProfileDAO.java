package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.MemberBean;

public class UpdateProfileDAO {
	public static UpdateProfileDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private UpdateProfileDAO() {
		
	}
	
	public static UpdateProfileDAO getInstance() {
		if(instance==null) {
			instance = new UpdateProfileDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public int selectUpdateMember(MemberBean Member) {
		String sql = "UPDATE MEMBER SET PROFILE_IMG=? where ID=?";
		int UpdateMember=0;
		try {
			pstmt = con.prepareStatement(sql);
			//sql ?에 들어갈 부분 순차적으로 작성
			pstmt.setString(1,Member.getPROFILE_IMG());
			pstmt.setString(2,Member.getID());
			//쿼리를 실행
			UpdateMember=pstmt.executeUpdate();
			}catch(Exception e) {
			System.out.println("UpdateMemberSQL에러:"+e);
			}finally {
			close(pstmt);
		}
		return UpdateMember ;
	}
	
}
