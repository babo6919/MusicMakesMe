package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.MemberBean;

public class MemberViewDAO {
	public static MemberViewDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private MemberViewDAO() {}
	public static MemberViewDAO getInstance() {
		if(instance == null) {
			instance = new MemberViewDAO();
		}return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}
	public MemberBean selectView(String View_Id) {
		String id=View_Id;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		MemberBean memberView = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberView = new MemberBean();
				memberView.setID(rs.getString("ID"));
				memberView.setPW(rs.getString("PW"));
				memberView.setNAME(rs.getString("NAME"));
				memberView.setADDR(rs.getString("ADDR"));
				memberView.setEMAIL(rs.getString("EMAIL"));
				memberView.setPOINT(rs.getInt("POINT"));
				memberView.setPROFILE_IMG(rs.getString("PROFILE_IMG"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("SelectViewSQL 에러:"+e);
		}finally {
			try {
				if(rs!=null)close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return memberView;
	}
}
