package kr.co.goodee39.ch10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GuestDAO {
	public int insertCount(Connection conn) throws Exception{
		String query = "update guest set cnt=cnt+1";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		return pstmt.executeUpdate();
	}
	
	public int selectCount(Connection conn) throws Exception{
		String query = "select cnt from guest";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		int result = 0;
		
		while(rs.next()) {
			result = rs.getInt("cnt");
		}
		
		return result;
	}
}
