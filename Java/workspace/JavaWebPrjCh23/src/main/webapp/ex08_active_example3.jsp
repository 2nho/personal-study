<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kr.co.goodee39.vo.MemberVO"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="kr.co.goodee39.config.SqlSessionManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	MemberVO vo = new MemberVO();
	vo.setId(1115);
	vo.setPassword("gggg");
	vo.setName("강감찬");
	
	int i = 0;
	try{
		i = sqlSession.update("member.activeUpdate1", vo);
		if(i>0){
			sqlSession.commit();
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<p><%=i %>개의 행이 갱신되었습니다.</p>
</body>
</html>