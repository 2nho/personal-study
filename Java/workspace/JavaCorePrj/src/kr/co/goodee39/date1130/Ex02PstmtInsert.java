package kr.co.goodee39.date1130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex02PstmtInsert {
	String connect = "jdbc:mariadb://localhost:3306/scott";
	String user = "root";
	String password = "1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Ex02PstmtInsert() {
		try {
			// 1. Driver 등록
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. connection 얻기
			conn = DriverManager.getConnection(connect, user, password);
			// 3. PreparedStatement 얻기
			String query = "insert into dept(deptno, dname, loc) values(?,?,?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 50);
			pstmt.setString(2, "AAAA");
			pstmt.setString(3, "BBBB");
			// 4. 쿼리 실행
			int i = pstmt.executeUpdate();
			System.out.println("처리 결과 : " + i);
		} catch (Exception e) {
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
		new Ex02PstmtInsert();
	}

}
