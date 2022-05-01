<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str1 = request.getParameter("test1");
	String str2 = request.getParameter("test2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 Example5_1.jsp 페이지입니다.</h1>
	<h3>str1 : <%=str1 %></h3>
	<h3>str2 : <%=str2 %></h3>
</body>
</html>