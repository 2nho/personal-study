<%@page import="kr.co.goodee39.vo.MemberVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
	
	List<Map<String, Object>> list1 = null;
	List<MemberVO> list2 = null;
	
	try{
		list1 = sqlSession.selectList("member.getList");
		list2 = sqlSession.selectList("member.getListByVO");
	}catch(Exception e){
		e.printStackTrace();
	}
%>

<% for(Map<String,Object> map : list1){ %>
	<p>이름 : <%=map.get("NAME") %>, id : <%=map.get("ID") %> </p>
<%} %>

<% for(MemberVO vo : list2){ %>
	<p>이름 : <%=vo.getName() %>, id : <%=vo.getId() %> </p>
<%} %>
</body>
</html>




