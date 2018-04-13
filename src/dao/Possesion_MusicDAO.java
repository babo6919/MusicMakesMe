package dao;

import static db.JdbcUtil.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.Possesion_MusicBean;

public class Possesion_MusicDAO {

	public static Possesion_MusicDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private Possesion_MusicDAO() {}
	public static Possesion_MusicDAO getInstance() {
		if(instance == null) {
			instance = new Possesion_MusicDAO();
		}return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}

	public int insertMember(Possesion_MusicBean MyMusic) {
		String sql = "INSERT INTO POSSESION_MUSIC (MUSIC_NUM, ARTIST, TITLE, MUSIC_FILE_NAME, MUSIC_FILE_DIR, IMG_FILE_NAME, ID) SELECT music.MUSIC_NUM, music.ARTIST,music.TITLE,music.MUSIC_FILE_NAME, music.MUSIC_FILE_DIR, music.IMG_FILE_NAME, member.ID FROM MUSIC, MEMBER WHERE ID=? and MUSIC_NUM=? and not exists (select music_num from possesion_MUSIC where ID=? and MUSIC_NUM=?)and point>=(select Deduct_point from music where music_num=?)";
		int insertCount=0;
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,MyMusic.getID());
			pstmt.setInt(2,MyMusic.getMUSIC_NUM());
			pstmt.setString(3,MyMusic.getID());
			pstmt.setInt(4,MyMusic.getMUSIC_NUM());
			pstmt.setInt(5,MyMusic.getMUSIC_NUM());
			insertCount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("MyMusic err :"+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
}

