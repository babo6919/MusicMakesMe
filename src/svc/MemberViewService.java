package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import java.sql.Connection;
import dao.MemberViewDAO;
import vo.MemberBean;

public class MemberViewService {
	
	public MemberBean getMember(String View_Id){
		Connection con = getConnection();
		MemberViewDAO memberViewDAO =MemberViewDAO.getInstance();
		memberViewDAO.setConnection(con);
		MemberBean memberView =memberViewDAO.selectView(View_Id);
		System.out.println("뷰 보기 성공");
		close(con);
		return memberView;
	}

}
