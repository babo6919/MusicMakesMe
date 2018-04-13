package svc;

import vo.MemberBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.JoinDAO;

public class JoinService {
	public boolean JoinMember(MemberBean member) {
			boolean joinSuccess = false;
			JoinDAO joinDAO = JoinDAO.getInstance();
			Connection con = getConnection();
			joinDAO.setConnection(con);
			
			//insert 쿼리가 성공하면 1이상의 값을 리턴받고 제대로 되지않으면
			//0을 리턴하게 함. 리턴받는 값을 통해 성공, 실패 여부 확인.
			int insertCount = joinDAO.insertMember(member);
			System.out.println("회원가입 성공");
			if(0<insertCount) {
				joinSuccess=true;
				commit(con);
			}else {
				rollback(con); //실패했을경우 돌아가기
			}
			close(con);
			return joinSuccess;//리턴은 마지막부분에 작성
	}

}
