package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.MyMusicListDAO;
import vo.Possesion_MusicBean;

public class MyMusicListService {
	public ArrayList<Possesion_MusicBean> getMusicList(String ID){
		Connection con = getConnection();
		MyMusicListDAO mymusiclistDAO =MyMusicListDAO.getInstance();
		mymusiclistDAO.setConnection(con);
		ArrayList<Possesion_MusicBean> mymusicList =mymusiclistDAO.selectMyMusicList(ID);
		System.out.println("서비스 : " + mymusicList);
		System.out.println("MyMusic리스트 보기 성공");
		close(con);
		return mymusicList;
	}
}
