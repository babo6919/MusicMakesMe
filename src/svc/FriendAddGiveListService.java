package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import dao.FriendAddGiveListDAO;

import vo.FriendStateBean;

public class FriendAddGiveListService {
	public ArrayList<FriendStateBean> getFriendList(String ID){
		Connection con = getConnection();
		FriendAddGiveListDAO friendStateListDAO = FriendAddGiveListDAO.getInstance();
		friendStateListDAO.setConnection(con);
		ArrayList<FriendStateBean> friendList = friendStateListDAO.selectStateFriendList(ID);
		System.out.println("서비스 :" + friendList);
		System.out.println("MyFriend리스트 보기 성공");
		close(con);
		return friendList;
	}

}
