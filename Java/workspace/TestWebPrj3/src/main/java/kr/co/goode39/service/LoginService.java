package kr.co.goode39.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.goodee39.conn.SqlSessionManager;
import kr.co.goodee39.vo.UserVO;

public class LoginService {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	public UserVO getUser(UserVO vo) {
		return sqlSession.selectOne("user.selectAccount", vo);
	}
	
	public void setUser(UserVO vo) {
		int i = sqlSession.insert("user.insertAccount", vo);
		if(i>0) {
			sqlSession.commit();
		}
	}
}
