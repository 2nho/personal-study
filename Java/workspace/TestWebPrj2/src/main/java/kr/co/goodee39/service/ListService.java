package kr.co.goodee39.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.goodee39.conn.SqlSessionManager;
import kr.co.goodee39.vo.BBSVO;

public class ListService {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();

	public void getList(HttpServletRequest request) {
		request.setAttribute("list", sqlSession.selectList("bbs.selectBBSList"));
	}

	public void setList(HttpServletRequest request) {
		try {
			BBSVO vo = new BBSVO();
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setOwner("김근형");
			String date = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(new Date());

			vo.setCreatedate(date);

			int i = sqlSession.insert("bbs.insertBBSList", vo);
			if (i > 0) {
				sqlSession.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
