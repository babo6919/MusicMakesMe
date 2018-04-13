package dao;

import static db.JdbcUtil.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.MemberBean;
import vo.MusicBean;

public class SearchDAO {

	public static SearchDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private SearchDAO() {}
	public static SearchDAO getInstance() {
		if(instance == null) {
			instance = new SearchDAO();
		}return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}

	public ArrayList<MemberBean> selectSearchFriendList(String id) {
		
		ArrayList<MemberBean> searchFriendList = new ArrayList<MemberBean>();
		try {
			String sql = "SELECT * FROM MEMBER WHERE UPPER(ID) LIKE UPPER('%"+id+"%')";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();		
				while(rs.next()) {
					MemberBean memberBean = new MemberBean();
					memberBean.setID(rs.getString("ID"));
					memberBean.setNAME(rs.getString("NAME"));
					memberBean.setPROFILE_IMG(rs.getString("PROFILE_IMG"));
					searchFriendList.add(memberBean);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("searchFriendListSQL �뿉�윭:"+e);
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return searchFriendList;
	}
	public ArrayList<MusicBean> selectSearchMusicList(String id) {
		
		ArrayList<MusicBean> searchMusicList = new ArrayList<MusicBean>();
		try {
			String sql = "SELECT * FROM MUSIC WHERE UPPER(TITLE) LIKE UPPER('%"+id+"%')";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();		
				while(rs.next()) {
					MusicBean musicBean = new MusicBean();
					musicBean.setMUSIC_NUM(rs.getInt("MUSIC_NUM"));
					musicBean.setTITLE(rs.getString("TITLE"));
					musicBean.setARTIST(rs.getString("ARTIST"));
					musicBean.setMUSIC_FILE_DIR(rs.getString("MUSIC_FILE_DIR"));
					musicBean.setMUSIC_FILE_NAME(rs.getString("MUSIC_FILE_NAME"));
					musicBean.setDEDUCT_POINT(rs.getInt("DEDUCT_POINT"));
					musicBean.setIMG_FILE_NAME(rs.getString("IMG_FILE_NAME"));
					searchMusicList.add(musicBean);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("searchMusicListSQL �뿉�윭:"+e);
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return searchMusicList;
	}
}
