package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import dao.FriendListDAO;

import vo.FriendListBean;

public class FriendListService {
	public ArrayList<FriendListBean> getFriendList(String ID){
		Connection con = getConnection();
		FriendListDAO friendListDAO = FriendListDAO.getInstance();
		friendListDAO.setConnection(con);
		ArrayList<FriendListBean> friendList = friendListDAO.selectFriendList(ID);
		System.out.println("서비스 :" + friendList);
		System.out.println("MyFriend리스트 보기 성공");
		close(con);
		return friendList;
	}

}
