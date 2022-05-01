<%@page import="kr.co.goodee39.vo.MemberMapper"%>
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
	
	Map map = new HashMap();
	MemberVO vo = null;
	MemberMapper mapper = null;
	
	try{
		map = sqlSession.selectOne("member.getFirstMember");
		vo = sqlSession.selectOne("member.getFirstMemberWithVO");
		mapper = sqlSession.selectOne("member.getFirstMemberWithMapper");
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<p>세부내용 : <%=map.toString()%></p>
<p>아이디 : <%=map.get("ID")%></p>
<p>VO 출력 => 아이디 : <%=vo.getId() %> , 패스워드 : <%=vo.getPassword() %></p>
<p>Mapper 출력 => 아이디 : <%=mapper.getUserId() %> , 패스워드 : <%=mapper.getUserPassword() %> </p>
</body>
</html>

