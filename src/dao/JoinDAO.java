package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.MemberBean;

public class JoinDAO {
	public static JoinDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private JoinDAO() {
		
	}
	
	public static JoinDAO getInstance() {
		if(instance==null) {
			instance = new JoinDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	
	public int insertMember(MemberBean Member) {
		String sql = "INSERT INTO MEMBER(ID,PW,NAME,EMAIL,ADDR) VALUES(?,?,?,?,?)";
		int insertCount=0;
		try {
			pstmt = con.prepareStatement(sql);
			//sql ?에 들어갈 부분 순차적으로 작성
			pstmt.setString(1,Member.getID());
			pstmt.setString(2,Member.getPW());
			pstmt.setString(3,Member.getNAME());
			pstmt.setString(4,Member.getEMAIL());
			pstmt.setString(5,Member.getADDR());
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
