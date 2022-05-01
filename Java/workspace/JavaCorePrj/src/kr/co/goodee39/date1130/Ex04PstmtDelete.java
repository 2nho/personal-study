package kr.co.goodee39.date1130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex04PstmtDelete {
	String connect = "jdbc:mariadb://localhost:3306/scott";
	String user = "root";
	String password = "1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Ex04PstmtDelete() {
		try {
			// 1. Driver 등록
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. connection 얻기
			conn = DriverManager.getConnection(connect, user, password);
			// 오토 커밋 끄기
			conn.setAutoCommit(false);
			// 3. PreparedStatement 얻기
			String query = "delete from dept where deptno = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 50);
			
			// 4. 쿼리 실행
			int i = pstmt.executeUpdate();
			System.out.println("처리 결과 : " + i);
//			conn.rollback();
			if(i > 0)conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			}catch (Exception e3) {
				e3.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new Ex04PstmtDelete();
	}

}
