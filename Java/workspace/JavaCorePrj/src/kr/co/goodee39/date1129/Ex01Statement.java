package kr.co.goodee39.date1129;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex01Statement {
	
	String connect = "jdbc:mariadb://localhost:3306/scott";
	String user = "root";
	String password = "1234";
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public Ex01Statement() {
		try {
			// 1.driver 등록
			Class.forName("org.mariadb.jdbc.Driver");
			// 2.네트워크 연결
			conn = DriverManager.getConnection(connect,user,password);
			// 3.statement 얻기
			stmt = (Statement)conn.createStatement();
			// 4. 쿼리작성
			String query = "select * from emp";
			// 5. 쿼리 실행 후 결과 집합 얻기
			rs = stmt.executeQuery(query);
			// 6. rs를 돌려 확인
			while(rs.next()) {
				int num = rs.getInt("empno");
				String name = rs.getString("ename");
				String job = rs.getString("job");
				System.out.println(num+"--"+name+"--"+job);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Ex01Statement();
	}

}
