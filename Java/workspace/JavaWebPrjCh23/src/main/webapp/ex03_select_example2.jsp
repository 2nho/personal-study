<%@page import="kr.co.goodee39.vo.MemberVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
	
	String email = "aaa@aaa.com";
	String name1 = null;
	String name2 = null;
	String name3 = null;
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("email", "aaa@aaa.com");
	map.put("id", 1111);
	
	MemberVO vo = new MemberVO();
	vo.setEmail("aaa@aaa.com");
	vo.setId(1111);
	try{
		name1 = sqlSession.selectOne("member.getName", email);
		name2 = sqlSession.selectOne("member.getNameFromMap", map);
		name3 = sqlSession.selectOne("member.getNameFromVO", vo);
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<p>이름1 : <%=name1%></p>
<p>이름2 : <%=name2%></p>
<p>이름3 : <%=name3%></p>
</body>
</html>