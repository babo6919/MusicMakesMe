package dao;

import java.sql.Connection;

import vo.FriendListBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;

import static db.JdbcUtil.*;

public class FriendListDAO {

	public static FriendListDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private FriendListDAO() {}
	public static FriendListDAO getInstance() {
		if(instance == null) {
			instance = new FriendListDAO();
		}return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}

	public ArrayList<FriendListBean> selectFriendList(String ID) {
		String id=ID;
		String sql = "SELECT FRIEND_LiST.FRIEND_ID, member.PROFILE_IMG from FRIEND_LiST,member where member.ID = FRIEND_LiST.FRIEND_ID and FRIEND_LIST.ID=?";
		ArrayList<FriendListBean> friendList = new ArrayList<FriendListBean>();
		FriendListBean friendListBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					friendListBean = new FriendListBean();		
					friendListBean.setFRIEND_ID(rs.getString("FRIEND_ID"));
					friendListBean.setPROFILE_IMG(rs.getString("PROFILE_IMG"));
					friendList.add(friendListBean);
				}while(rs.next());
			}
			System.out.println(friendList);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FriendListSQL 에러:"+e);
		}finally {
			try {
				if(rs!=null)close(rs);
				if(pstmt!=null)close(pstmt);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return friendList;
	}
}

