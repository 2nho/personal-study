package kr.co.goodee39.ch10.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.goodee39.ch10.dao.StoreDAO;
import kr.co.goodee39.conn.JDBCCreateConn;

public class Quiz201Service {
	public void setAmount(HttpServletRequest request) {
		try {
			StoreDAO dao = new StoreDAO();
			
			int num = Integer.parseInt(request.getParameter("num"));
			int menu = Integer.parseInt(request.getParameter("menu"));
			
			dao.insertStore(JDBCCreateConn.getConn(), 
					num*menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAmount(HttpServletRequest request) {
		try {
			StoreDAO dao = new StoreDAO();
			request.setAttribute("amount", dao.selectStore(JDBCCreateConn.getConn()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
