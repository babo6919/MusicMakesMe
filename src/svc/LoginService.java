package svc;

import vo.MemberBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.LoginDAO;

//로그인 처리를 위한 비즈니스 로직이 있는  클래스ㅜ
//db 접속을 위해 DAO 객체를 호출하고
//메소드 수행결과를 Member_Login_Action 클래스로 리턴함

public class LoginService {
	public boolean Login(MemberBean Member) {
		//db연결을 하고 DAO 클래스로 로그인과 관련된 sql문을 가지고 있는 메소드 호출
		Connection con = getConnection();
		LoginDAO loginDAO= LoginDAO.getInstance();
		loginDAO.setConnection(con);
		boolean LoginResult = false;
		//memberDAO.selectLoginId(member)의 호출 결과는 LoginId
		String LoginId = loginDAO.selectLoginId(Member);
		if(LoginId != null) {
			LoginResult = true;
			System.out.println("로그인 성공");
		}
		close(con);
		//id가 db에 존재하면 loginResult가 ture
		//아니면 false
		return LoginResult;
	}
}
