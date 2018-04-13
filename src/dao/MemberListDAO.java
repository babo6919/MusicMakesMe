package dao;

import java.sql.Connection;

import vo.MemberBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static db.JdbcUtil.*;

public class MemberListDAO {

	public static MemberListDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private MemberListDAO() {}
	public static MemberListDAO getInstance() {
		if(instance == null) {
			instance = new MemberListDAO();
		}return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}

	public ArrayList<MemberBean> selectMemberList() {
		String sql = "SELECT * FROM MEMBER";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean memberBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					memberBean = new MemberBean();
					memberBean.setID(rs.getString("ID"));
					memberBean.setPROFILE_IMG(rs.getString("PROFILE_IMG"));
					memberList.add(memberBean);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("MemberListSQL 에러:"+e);
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return memberList;
	}
}
