<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	int a = Integer.parseInt(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<% for(int i = 1; i<=a ; i++){%>
		<li><%=i %></li>
		<% } %>
	</ul>
</body>
</html>