package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;


import dao.MemberListDAO;
import vo.MemberBean;

public class MemberListService {
		public ArrayList<MemberBean> getMemberList() {
			Connection con = getConnection();
			MemberListDAO memberListDAO =MemberListDAO.getInstance();
			memberListDAO.setConnection(con);
			ArrayList<MemberBean> memberList =memberListDAO.selectMemberList();
			close(con);
			return memberList;
		}
}
