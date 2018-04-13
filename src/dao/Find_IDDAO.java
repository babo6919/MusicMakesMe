package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.MemberBean;

public class Find_IDDAO {
	
	public static Find_IDDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private Find_IDDAO() {
		
	}
	
	public static Find_IDDAO getInstance() {
		if(instance==null) {
			instance = new Find_IDDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public MemberBean selectMember(String email) {
		String sql="SELECT * FROM MEMBER WHERE EMAIL=lower('"+email+"')";
		/*ArrayList<MemberBean> memberView=new ArrayList<MemberBean>();*/
		MemberBean member = null;
		
		try{
			
			pstmt=con.prepareStatement(sql);
			/*pstmt.setString(1, viewId);*/
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				member=new MemberBean();
				member.setID(rs.getString("ID"));

			}
			System.out.println(rs.getString("ID"));		
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);		
		}finally{
			
			close(rs);
			close(pstmt);
		}
		
		return member;
	}
}
