package kr.co.goodee39.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.goodee39.conn.JDBCCreateConn;
import kr.co.goodee39.dao.MemberDAO;

public class Test1Servcie {
	public void getMember(HttpServletRequest request) {
		try {
			MemberDAO dao = new MemberDAO();
			request.setAttribute("vo", dao.selectMember(JDBCCreateConn.getConn()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
