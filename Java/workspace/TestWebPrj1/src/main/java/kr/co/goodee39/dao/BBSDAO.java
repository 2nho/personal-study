package kr.co.goodee39.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.goodee39.vo.BBSVO;

public class BBSDAO {
	public List<BBSVO> selectBBSList(Connection conn) throws Exception{
		String query = "select sid, title, owner, createdate from bbs";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<BBSVO> list = new ArrayList<BBSVO>();
		
		while(rs.next()) {
			BBSVO vo = new BBSVO();
			vo.setSid(rs.getInt("sid"));
			vo.setTitle(rs.getString("title"));
			vo.setOwner(rs.getString("owner"));
			vo.setCreateDate(rs.getString("createdate"));			
			list.add(vo);
		}
		return list;
	}
}
