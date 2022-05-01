package kr.co.goodee39.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.goodee39.conn.SqlSessionManager;

public class Test2Service {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
//	public void getBBSVOList(HttpServletRequest request) {
//		try {
//			BBSDAO dao = new BBSDAO();
//			request.setAttribute("list", dao.selectBBSList(JDBCCreateConn.getConn()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void getBBSVOList(HttpServletRequest request) {
		try {
			request.setAttribute("list", sqlSession.selectList("bbs.selectBBSList"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
