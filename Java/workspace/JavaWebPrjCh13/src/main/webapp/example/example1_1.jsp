<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sessiontScope.a}</h1>
	<h1>${sessiontScope.b}</h1>
	<h1>${c}</h1>
</body>
</html>