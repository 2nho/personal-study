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
	
	MemberVO vo1 = new MemberVO();
	vo1.setId(1115);
	vo1.setPassword("ffff");
	vo1.setName("을지문덕");
	vo1.setAge(40);
	vo1.setGender("남자");
	vo1.setEmail("eee@eee.com");
	
	MemberVO vo2 = new MemberVO();
	vo2.setName("강감찬");
	vo2.setId(1115);
	
	MemberVO vo3 = new MemberVO();
	vo3.setId(1115);
	
	MemberVO vo4 = new MemberVO();
	vo4.setPassword("ffff");
	vo4.setName("을지문덕");
	vo4.setAge(40);
	vo4.setGender("남자");
	vo4.setEmail("eee@eee.com");
	int i = 0;
	try{
		//i = sqlSession.insert("member.insertMember", vo1);
		//i = sqlSession.update("member.updateMember", vo2);
		//i = sqlSession.delete("member.deleteMember", vo3);
		i = sqlSession.insert("member.insertMember1", vo4);
		if(i>0){
			sqlSession.commit();
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<p> 행이 <%=i %>개 입력되었습니다. </p>
</body>
</html>

