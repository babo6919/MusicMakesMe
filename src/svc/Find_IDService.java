package svc;

import vo.MemberBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.Find_IDDAO;
import dao.MemberViewDAO;

public class Find_IDService {

	public MemberBean getMember(String email) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		Find_IDDAO find_IDDAO = Find_IDDAO.getInstance();
		find_IDDAO.setConnection(con);
		
		MemberBean member = find_IDDAO.selectMember(email);
		System.out.println("아이디 찾기 성공");
		close(con);
		return member;
	}

}
