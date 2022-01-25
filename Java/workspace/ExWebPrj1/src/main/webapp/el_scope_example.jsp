<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("page1", "페이지1");
	request.setAttribute("request1","리퀘1");
	session.setAttribute("session1", "세션1");
	application.setAttribute("app1", "어플1");
	
	pageContext.setAttribute("data1", "페이지 문자열1");
	request.setAttribute("data1", "리퀘 문자열1");
	session.setAttribute("data1", "세션 문자열1");
	application.setAttribute("data1", "어플 문자열1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${page1}</h3>
	<h3>${request1}</h3>
	<h3>${session1}</h3>
	<h3>${app1}</h3>
	<hr />
	<h3>${data1}</h3>
	<hr />
	<h3>${pageScope.data1}</h3>
	<h3>${requestScope.data1}</h3>
	<h3>${sessionScope.data1}</h3>
	<h3>${applicationScope.data1}</h3>
</body>
</html>



