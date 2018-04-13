package dao;

import static db.JdbcUtil.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class PurchaseDAO {
	public static PurchaseDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private PurchaseDAO() {
		
	}
	
	public static PurchaseDAO getInstance() {
		if(instance==null) {
			instance = new PurchaseDAO();
		}
	return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int selectPurchase(int Music_Num, String ID) {
	int Purchase=0;
	String id=ID;
	String sql = "update member set point=POINT-(select music.DEDUCT_POINT from music where music_num=?)where id=? and point>=(select Deduct_point from music where music_num=?)";
	
	//넘겨받은 member 객체의 id,pw 값을 통해 sql문을 이용하여 해당 id로
	//조회 된 id 값을 loginId에 담음 
	//loginId를 리턴
	//sql 작성
	try {
			pstmt = con.prepareStatement(sql);
			
			//loginId에 저장값 담음
	
			pstmt.setInt(1, Music_Num);
			pstmt.setString(2, id);	
			pstmt.setInt(3, Music_Num);
			//쿼리실행
			Purchase = pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("PurchaseSQL에러 :" + e);
		}
		finally {
				if(rs!=null)close(rs);
				close(pstmt);
		}	
		return Purchase;
	}

}
