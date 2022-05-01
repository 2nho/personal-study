package kr.co.goodee39.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.goodee39.vo.MemberVO;

public class MemberDAO {
	public MemberVO selectMember(Connection conn) throws Exception {
		String query = "select uid, uname, age, comments from member";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		MemberVO vo = new MemberVO();
		
		while(rs.next()) {
			vo.setUid(rs.getInt("uid"));
			vo.setUname(rs.getString("uname"));
			vo.setAge(rs.getInt("age"));
			vo.setComments(rs.getString("comments"));
		}
		
		return vo;
		
	}
}
