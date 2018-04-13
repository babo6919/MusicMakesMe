package svc;

import vo.FriendStateBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.FriendAddGiveCancleDAO;

public class FriendAddGiveCancleService {
	public boolean AddCancle(String ID, String FRIEND_ID) {
		// TODO Auto-generated method stub
		
		boolean Cancle_Result = false;
		Connection con = getConnection();
		FriendAddGiveCancleDAO friendAddCancleDAO =FriendAddGiveCancleDAO.getInstance();
		friendAddCancleDAO.setConnection(con);
		int Cancle_Count = friendAddCancleDAO.FriendaddCancle(ID,FRIEND_ID);
		if(Cancle_Count>0) {
			commit(con);
			Cancle_Result = true;
			System.out.println("삭제 성공");
		}else {
			rollback(con);
			System.out.println("삭제 실패");
		}
		return Cancle_Result;
	}

}
