package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import dao.FriendAddHaveListDAO;

import vo.FriendStateBean;

public class FriendAddHaveListService {
	public ArrayList<FriendStateBean> getFriendList(String ID){
		Connection con = getConnection();
		FriendAddHaveListDAO friendStateListDAO = FriendAddHaveListDAO.getInstance();
		friendStateListDAO.setConnection(con);
		ArrayList<FriendStateBean> friendList = friendStateListDAO.selectStateFriendList(ID);
		System.out.println("서비스 :" + friendList);
		System.out.println("MyFriend리스트 보기 성공");
		close(con);
		return friendList;
	}

}
