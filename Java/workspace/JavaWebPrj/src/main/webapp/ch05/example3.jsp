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
	// redirect	: 클라이언트 재요청
	// response.sendRedirect("example3_1.jsp");
	// forward : 서버내 요청
	pageContext.forward("example3_1.jsp");
	%>
</body>
</html>