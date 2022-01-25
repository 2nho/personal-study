package kr.co.goodee39.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.goodee39.conn.JDBCCreateConn;
import kr.co.goodee39.dao.BBSDAO;

public class Test2Service {
	public void getBBSVOList(HttpServletRequest request) {
		try {
			BBSDAO dao = new BBSDAO();
			request.setAttribute("list", dao.selectBBSList(JDBCCreateConn.getConn()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
