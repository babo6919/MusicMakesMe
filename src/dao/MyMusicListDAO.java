package dao;

import java.sql.Connection;

import vo.Possesion_MusicBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import static db.JdbcUtil.*;

public class MyMusicListDAO {

	public static MyMusicListDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private MyMusicListDAO() {}
	public static MyMusicListDAO getInstance() {
		if(instance == null) {
			instance = new MyMusicListDAO();
		}return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}

	public ArrayList<Possesion_MusicBean> selectMyMusicList(String id) {
		String sql = "SELECT * FROM POSSESION_MUSIC WHERE ID=?";
		ArrayList<Possesion_MusicBean> mymusicList = new ArrayList<Possesion_MusicBean>();
		Possesion_MusicBean	MymusicBean=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				do{
					MymusicBean = new Possesion_MusicBean();
					MymusicBean.setID(rs.getString("ID"));
					MymusicBean.setTITLE(rs.getString("TITLE"));
					MymusicBean.setARTIST(rs.getString("ARTIST"));
					MymusicBean.setMUSIC_FILE_NAME(rs.getString("MUSIC_FILE_NAME"));
					MymusicBean.setMUSIC_FILE_DIR(rs.getString("MUSIC_FILE_DIR"));
					MymusicBean.setIMG_FILE_NAME(rs.getString("IMG_FILE_NAME"));
					mymusicList.add(MymusicBean);
				}while(rs.next());
			}System.out.println("do while "+mymusicList);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("MyMusicListSQL 에러:"+e);
		}finally {
			try {
				if(rs!=null)close(rs);
				if(pstmt!=null)close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("DAO : " + mymusicList);
		return mymusicList;
	}
}
