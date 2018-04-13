package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.PurchaseDAO;

public class PurchaseService {
	public boolean Purchase(int Music_Num, String ID) {
		//db연결을 하고 DAO 클래스로 로그인과 관련된 sql문을 가지고 있는 메소드 호출
		Connection con = getConnection();
		PurchaseDAO purchaseDAO= PurchaseDAO.getInstance();
		purchaseDAO.setConnection(con);
		boolean PurchaseResult = false;
		//memberDAO.selectLoginId(member)의 호출 결과는 LoginId
		int PurchaseId = purchaseDAO.selectPurchase(Music_Num, ID);
		if(PurchaseId>0) {
			PurchaseResult = true;
			System.out.println("구매 성공");
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		//id가 db에 존재하면 loginResult가 ture
		//아니면 false
		return PurchaseResult;
	}
}
