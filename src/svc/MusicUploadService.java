package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.MusicUploadDAO;

import vo.MusicBean;
public class MusicUploadService {

	public boolean insertMusic(MusicBean Music) {
		MusicUploadDAO musicDAO = MusicUploadDAO.getInstance();
		Connection con = getConnection();
		musicDAO.setConnection(con);		
		boolean isRegistSuccess = false;		
		int insertCount = musicDAO.selectUploadMusic(Music);
		System.out.println("음악 업로드 성공");
		if(insertCount>0){
			commit(con);
			isRegistSuccess=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}

}
