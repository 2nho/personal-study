<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String[] strs = request.getParameterValues("ch");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>나의 취미는</h1>
	<ul>
		<%for(String str : strs){ %>
		<li><%=str%></li>
		<%} %>
	</ul>
</body>
</html>