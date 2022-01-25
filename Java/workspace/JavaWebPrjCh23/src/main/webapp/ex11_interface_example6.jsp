<%@page import="kr.co.goodee39.mapper.MemberQueryMapper1"%>
<%@page import="kr.co.goodee39.vo.MemberVO"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="kr.co.goodee39.config.SqlSessionManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	MemberQueryMapper1 mapper = sqlSession.getMapper(MemberQueryMapper1.class);
	
	int i = 0;
	try{
		i = mapper.getCount();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<p>현재 행 개수 : <%=i %></p>
</body>
</html>