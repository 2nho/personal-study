<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String[] strs = request.getParameterValues("file");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내가 올린 파일</h1>
	<ul>
		<%for(String str : strs){ %>
		<li><%=str %></li>
		<%} %>
	</ul>
</body>
</html>