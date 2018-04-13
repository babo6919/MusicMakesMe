package dao;

import java.sql.Connection;

import vo.MusicBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import static db.JdbcUtil.*;

public class MusicListDAO {

	public static MusicListDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private MusicListDAO() {}
	public static MusicListDAO getInstance() {
		if(instance == null) {
			instance = new MusicListDAO();
		}return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}

	public ArrayList<MusicBean> selectMusicList() {
		String sql = "SELECT * FROM MUSIC";
		ArrayList<MusicBean> musicList = new ArrayList<MusicBean>();
		MusicBean musicBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					musicBean = new MusicBean();
					musicBean.setMUSIC_NUM(rs.getInt("MUSIC_NUM"));
					musicBean.setTITLE(rs.getString("TITLE"));
					musicBean.setARTIST(rs.getString("ARTIST"));
					musicBean.setMUSIC_FILE_NAME(rs.getString("MUSIC_FILE_NAME"));
					musicBean.setMUSIC_FILE_DIR(rs.getString("MUSIC_FILE_DIR"));
					musicBean.setDEDUCT_POINT(rs.getInt("DEDUCT_POINT"));
					musicList.add(musicBean);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("MusicListSQL 에러:"+e);
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return musicList;
	}
}
