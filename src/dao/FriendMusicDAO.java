package dao;

import java.sql.Connection;


import vo.Possesion_MusicBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;

import static db.JdbcUtil.*;

public class FriendMusicDAO {

	public static FriendMusicDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private FriendMusicDAO() {}
	public static FriendMusicDAO getInstance() {
		if(instance == null) {
			instance = new FriendMusicDAO();
		}return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}

	public ArrayList<Possesion_MusicBean> selectMusicList(String ID) {
		String sql = "SELECT * FROM POSSESION_MUSIC WHERE ID=?";
		ArrayList<Possesion_MusicBean> friendMusic = new ArrayList<Possesion_MusicBean>();
		Possesion_MusicBean musicBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					musicBean = new Possesion_MusicBean();		
					musicBean.setTITLE(rs.getString("TITLE"));
					musicBean.setARTIST(rs.getString("ARTIST"));
					musicBean.setMUSIC_FILE_NAME(rs.getString("MUSIC_FILE_NAME"));
					musicBean.setMUSIC_FILE_DIR(rs.getString("MUSIC_FILE_DIR"));
					musicBean.setIMG_FILE_NAME(rs.getString("IMG_FILE_NAME"));
					friendMusic.add(musicBean);
				}while(rs.next());
			}

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FriendMusicListSQL 에러:"+e);
		}finally {
			try {
				close(rs);
				close(pstmt);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return friendMusic;
	}
}

