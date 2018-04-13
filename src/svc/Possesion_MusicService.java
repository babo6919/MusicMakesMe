package svc;

import static db.JdbcUtil.*;


import java.sql.Connection;

import dao.Possesion_MusicDAO;
import vo.Possesion_MusicBean;

public class Possesion_MusicService {
	public boolean getMyMusicList(Possesion_MusicBean MyMusic){
		Connection con = getConnection();
		Possesion_MusicDAO myMusicDAO = Possesion_MusicDAO.getInstance();
		myMusicDAO.setConnection(con);
		boolean MyMusicSuccess = false;
		
		int insertCount = myMusicDAO.insertMember(MyMusic);
		System.out.println("Service");
		if(0<insertCount) {
			MyMusicSuccess=true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return MyMusicSuccess;
	}
	
}
