<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str1 = (String)session.getAttribute("str1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>현재 세션에 저장된 str1의 값은 <%=str1 %> 입니다.</h1>
</body>
</html>