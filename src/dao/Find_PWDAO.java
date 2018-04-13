package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.MemberBean;

public class Find_PWDAO {
	
	public static Find_PWDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private Find_PWDAO() {
		
	}
	
	public static Find_PWDAO getInstance() {
		if(instance==null) {
			instance = new Find_PWDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public MemberBean selectMember(String email, String id) {
		String sql="SELECT PW FROM MEMBER WHERE EMAIL=lower('"+email+"')and id=lower('"+id+"')";
		/*ArrayList<MemberBean> memberView=new ArrayList<MemberBean>();*/
		MemberBean member2 = null;
		
		try{
			
			pstmt=con.prepareStatement(sql);
			/*pstmt.setString(1, viewId);*/
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				member2=new MemberBean();
				member2.setPW(rs.getString("PW"));

			}
			System.out.println(rs.getString("PW"));		
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);		
		}finally{
			
			close(rs);
			close(pstmt);
		}
		
		return member2;
	}
}
