package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SearchDAO;
import vo.MemberBean;
import vo.MusicBean;

public class SearchService {
	public ArrayList<MemberBean> getSearchList(String id) {
			Connection con = getConnection();
			SearchDAO SearchListDAO =SearchDAO.getInstance();
			SearchListDAO.setConnection(con);
			ArrayList<MemberBean> searchFriendList =SearchListDAO.selectSearchFriendList(id);
			System.out.println("프렌드 서치 성공");
			close(con);
			return searchFriendList;
		}
	public ArrayList<MusicBean> getSearchMusicList(String id) {
		Connection con = getConnection();
		SearchDAO SearchListDAO =SearchDAO.getInstance();
		SearchListDAO.setConnection(con);
		ArrayList<MusicBean> searchMusicList =SearchListDAO.selectSearchMusicList(id);
		System.out.println("음악 서치 성공");
		close(con);
		return searchMusicList;
	}

}
