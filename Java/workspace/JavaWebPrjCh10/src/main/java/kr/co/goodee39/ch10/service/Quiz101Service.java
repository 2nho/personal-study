package kr.co.goodee39.ch10.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.goodee39.ch10.dao.GuestDAO;
import kr.co.goodee39.conn.JDBCCreateConn;

public class Quiz101Service {
	public void getCount(HttpServletRequest request) {
		try {
			GuestDAO dao = new GuestDAO();
			int i = dao.insertCount(JDBCCreateConn.getConn());
			if(!(i>0)) {
				throw new Exception();
			}else {
				int cnt = dao.selectCount(JDBCCreateConn.getConn());
				request.setAttribute("cnt", cnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
