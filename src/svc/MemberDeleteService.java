
package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDeleteDAO;


public class MemberDeleteService {

	public boolean Delete_Member(String Delete_Id) {
		// TODO Auto-generated method stub
		
		boolean Delete_Result = false;
		Connection con = getConnection();
		MemberDeleteDAO memberDeleteDAO =MemberDeleteDAO.getInstance();
		memberDeleteDAO.setConnection(con);
		int Delete_Count = memberDeleteDAO.DeleteMember(Delete_Id);
		if(Delete_Count>0) {
			commit(con);
			Delete_Result = true;
			System.out.println("삭제 성공");
		}else {
			rollback(con);
			System.out.println("삭제 실패");
		}
		return Delete_Result;
	}
	public boolean Draw_Member(String ID) {
		// TODO Auto-generated method stub
		
		boolean Draw_Result = false;
		Connection con = getConnection();
		MemberDeleteDAO memberDeleteDAO =MemberDeleteDAO.getInstance();
		memberDeleteDAO.setConnection(con);
		int Draw_Count = memberDeleteDAO.DrawMember(ID);
		if(Draw_Count>0) {
			commit(con);
			Draw_Result = true;
			System.out.println("삭제 성공");
		}else {
			rollback(con);
			System.out.println("삭제 실패");
		}
		return Draw_Result;
	}

}
