package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UpdateProfileDAO;
import vo.MemberBean;

public class UpdateProfileService {
	public boolean UpdateMember(MemberBean Member){
	boolean UpdateSuccess = false;
	Connection con = getConnection();
	UpdateProfileDAO updateProfileDAO= UpdateProfileDAO.getInstance();
	updateProfileDAO.setConnection(con);
	//memberDAO.selectLoginId(member)의 호출 결과는 LoginId
	int UpdateMember = updateProfileDAO.selectUpdateMember(Member);
	System.out.println("회원정보 수정 성공");
	if(0<UpdateMember) {
		UpdateSuccess=true;
		commit(con);
	}else {
		rollback(con); //실패했을경우 돌아가기
	}
	close(con);
	return UpdateSuccess;//리턴은 마지막부분에 작성
}
}

