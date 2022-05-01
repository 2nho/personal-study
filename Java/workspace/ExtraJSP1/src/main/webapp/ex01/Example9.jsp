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
	Cookie cookie = new Cookie("str1","1000");
	cookie.setMaxAge(3600);
	response.addCookie(cookie);
	
	response.sendRedirect(request.getContextPath()+"/ex01/Example9_1.jsp");
%>
</body>
</html>