package svc;

import vo.MemberBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.Find_PWDAO;


public class Find_PWService {

	public MemberBean getMember(String email, String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		Find_PWDAO find_PWDAO = Find_PWDAO.getInstance();
		find_PWDAO.setConnection(con);
		
		MemberBean member2 = find_PWDAO.selectMember(email , id);
		System.out.println("비밀번호 찾기 성공");
		close(con);
		return member2;
	}

}
