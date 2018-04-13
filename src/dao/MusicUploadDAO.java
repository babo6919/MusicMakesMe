package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;

import vo.MusicBean;

public class MusicUploadDAO {
	public static MusicUploadDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private MusicUploadDAO() {
		
	}
	
	public static MusicUploadDAO getInstance() {
		if(instance==null) {
			instance = new MusicUploadDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	
	public int selectUploadMusic(MusicBean Music) {
		String sql = "INSERT INTO MUSIC(MUSIC_NUM,TITLE,ARTIST,MUSIC_FILE_NAME,MUSIC_FILE_DIR,DEDUCT_POINT,IMG_FILE_NAME)"
				+ "VALUES(MUSIC_NUM.nextval,?,?,?,?,?,?)";
		int insertCount=0;
		try {
			pstmt = con.prepareStatement(sql);
			//sql ?에 들어갈 부분 순차적으로 작성
			pstmt.setString(1,Music.getTITLE());
			pstmt.setString(2,Music.getARTIST());
			pstmt.setString(3,Music.getMUSIC_FILE_NAME());
			pstmt.setString(4,Music.getMUSIC_FILE_DIR());
			pstmt.setInt(5, Music.getDEDUCT_POINT());
			pstmt.setString(6,Music.getIMG_FILE_NAME());

			//쿼리를 실행
			insertCount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("MusicUploadSQL 에러 :"+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}

	
}
