package db;
//DB관련 작업을 위한 import
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	//DB연결을 위한 getConncetion
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			//""안의 내용은 context.xml에 있는 name 값. 틀릴경우 DB x
			DataSource ds = (DataSource)envCtx.lookup("jdbc/OracleDB");
			con = ds.getConnection();
			con.setAutoCommit(false);
			} catch(Exception e) {
				e.printStackTrace();
			}
		return con;
	}
	public static void close(Connection con) {
		try {
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("con.close 에러"+e);
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("stmt.close 에러"+e);
			}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("rs.close 에러"+e);
			}
	}
	public static void commit(Connection con) {
		try {
			con.commit();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("con.commit 에러"+e);
			}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("con.rollback 에러"+e);
			}
	}
}

