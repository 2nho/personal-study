package kr.co.goodee39.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.goodee39.conn.SqlSessionManager;


public class Test1Servcie {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();

//	public void getMember(HttpServletRequest request) {
//		try {
//			MemberDAO dao = new MemberDAO();
//			request.setAttribute("vo", dao.selectMember(JDBCCreateConn.getConn()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void getMember(HttpServletRequest request) {
		try {
			request.setAttribute("vo", sqlSession.selectOne("member.selectMember"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
