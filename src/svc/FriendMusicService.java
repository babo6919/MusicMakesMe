package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import dao.FriendMusicDAO;
import vo.Possesion_MusicBean;

public class FriendMusicService {
	public ArrayList<Possesion_MusicBean> getMusicList(String ID){
		Connection con = getConnection();
		FriendMusicDAO friendMusicDAO =FriendMusicDAO.getInstance();
		friendMusicDAO.setConnection(con);
		
		ArrayList<Possesion_MusicBean> friendMusic =friendMusicDAO.selectMusicList(ID);
		System.out.println("서비스 FriendMusicList :" + friendMusic);
		close(con);
		return friendMusic;
	}
}
