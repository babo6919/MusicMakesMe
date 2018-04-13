package dao;

import java.sql.Connection;
import vo.FriendStateBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;

import static db.JdbcUtil.*;

public class FriendAddGiveListDAO {

	public static FriendAddGiveListDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private FriendAddGiveListDAO() {}
	public static FriendAddGiveListDAO getInstance() {
		if(instance == null) {
			instance = new FriendAddGiveListDAO();
		}return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}

	public ArrayList<FriendStateBean> selectStateFriendList(String ID) {
		String id=ID;
		String sql = "SELECT FRIEND_STATE.FRIEND_ID, member.PROFILE_IMG from FRIEND_STATE,member where member.ID = FRIEND_STATE.FRIEND_ID and FRIEND_STATE.ID=?";
		ArrayList<FriendStateBean> friendList = new ArrayList<FriendStateBean>();
		FriendStateBean friendStateListBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					friendStateListBean = new FriendStateBean();		
					friendStateListBean.setFRIEND_ID(rs.getString("FRIEND_ID"));
					friendStateListBean.setPROFILE_IMG(rs.getString("PROFILE_IMG"));
					friendList.add(friendStateListBean);
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

