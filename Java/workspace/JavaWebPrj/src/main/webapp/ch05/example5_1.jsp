<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)request.getAttribute("id");
	String pw = (String)request.getAttribute("pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>example5_1.jsp 페이지 입니다.</h1>
	<p><%=id %></p>
	<p><%=pw %></p>
</body>
</html>