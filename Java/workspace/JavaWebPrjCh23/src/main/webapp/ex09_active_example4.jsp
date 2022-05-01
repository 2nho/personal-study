<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
	
	List<String> list = new ArrayList<String>();
	list.add("aaa@aaa.com");
	list.add("bbb@bbb.com");
	list.add("ccc@ccc.com");
	
	List<MemberVO> vo = null;
	try{
		vo = sqlSession.selectList("member.activeSelect3", list);		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<%for(MemberVO vo1 : vo){ %>
	<p>이름 : <%=vo1.getName() %></p>
<%} %>
</body>
</html>


