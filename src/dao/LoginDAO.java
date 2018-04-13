package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.MemberBean;
import static db.JdbcUtil.*;

//sql에 전달해서 클라이언트가 입력한 아이디 패스워들 조회해서 값을  리턴
public class LoginDAO {
	public static LoginDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private LoginDAO() {
		
	}
	
	public static LoginDAO getInstance() {
		if(instance==null) {
			instance = new LoginDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public String selectLoginId(MemberBean member) {
	String LoginId=null;
	String point=null;
	String sql = "SELECT ID FROM MEMBER WHERE ID=? AND PW=?"; 
	
	//넘겨받은 member 객체의 id,pw 값을 통해 sql문을 이용하여 해당 id로
	//조회 된 id 값을 loginId에 담음 
	//loginId를 리턴
	//sql 작성
	try {
			pstmt = con.prepareStatement(sql);
			//loginId에 저장값 담음
			pstmt.setString(1, member.getID());
			pstmt.setString(2, member.getPW());
			//쿼리실행
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				LoginId = rs.getString("ID");
			}
			
		}catch(Exception e) {
			System.out.println("LoginSQL에러 :" + e);
		}
		finally {
			
				close(rs);
				close(pstmt);
			
		}	
		return LoginId;
	}

}

