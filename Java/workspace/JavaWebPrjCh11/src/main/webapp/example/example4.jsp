<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String s1 = "안녕하세요";
%>
<c:set var="s2" value="안녕하세요"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%=s1 %></p>
	<p>${s2 }</p>
	<c:out value="${s2}"/>
</body>
</html>