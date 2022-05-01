<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("aaa", "aaaaaa");
	session.setAttribute("bbb", "bbbbbb");
	session.setAttribute("aaa", "dddddd");
	application.setAttribute("ccc", "cccccc");
	application.setAttribute("aaa", "eeeeeee");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${aaa}</h1>
	<h1>${bbb}</h1>
	<h1>${ccc}</h1>
	<h1>${sessionScope.aaa}</h1>
	<h1>${applicationScope.aaa}</h1>
</body>
</html>