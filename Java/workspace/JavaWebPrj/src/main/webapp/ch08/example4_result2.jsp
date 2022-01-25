<%@page import="kr.co.goodee39.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	LoginBean vo = (LoginBean)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>id : <%=vo.getId() %></h2>
	<h2>pw : <%=vo.getPw() %></h2>
</body>
</html>