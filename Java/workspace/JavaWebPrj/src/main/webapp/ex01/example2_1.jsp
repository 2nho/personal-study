<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String[] datas = request.getParameterValues("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=id%></h1>
	<h1><%=pw%></h1>
	<%for(String data : datas){ %>
	<h1><%=data%></h1>
	<%} %>
</body>
</html>