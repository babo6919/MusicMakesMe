package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.MusicListDAO;
import vo.MusicBean;

public class MusicListService {
	public ArrayList<MusicBean> getMusicList(){
		Connection con = getConnection();
		MusicListDAO musiclistDAO =MusicListDAO.getInstance();
		musiclistDAO.setConnection(con);
		ArrayList<MusicBean> musicList =musiclistDAO.selectMusicList();
		System.out.println("Music리스트 보기 성공");
		close(con);
		return musicList;
	}
}
