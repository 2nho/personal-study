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
		String test1 = request.getParameter("test1");
		String test2 = request.getParameter("test2");
		
		String[] test3 = request.getParameterValues("test3");
	%>
	<p> test1 : <%=test1 %></p>
	<p> test2 : <%=test2 %></p>
	<% for(String t3_item : test3){ %>
		<p>test3 : <%=t3_item %>
	<%} %>
</body>
</html>