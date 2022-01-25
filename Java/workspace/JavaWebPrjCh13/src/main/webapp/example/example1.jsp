<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("a","aaa");
	session.setAttribute("b","bbb");
	request.setAttribute("c","ccc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 예제 첫 페이지입니다.</h1>
	<a href="${pageContext.request.contextPath}/Example1Controller">이동</a>
</body>
</html>