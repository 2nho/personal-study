package kr.co.goodee39.ch10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.goodee39.vo.DeptVO;

public class StoreDAO {
	public int insertStore(Connection conn, int amount) throws Exception{
		String query = "update ministore set stock=stock+?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, amount);
		
		int i = pstmt.executeUpdate();
		
		return i;
	}
	
	public int selectStore(Connection conn) throws Exception{
		String query = "select stock from ministore";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		int stock = 0;
		
		while(rs.next()) {
			stock = rs.getInt("stock");
		}
		
		return stock;
	}
}


