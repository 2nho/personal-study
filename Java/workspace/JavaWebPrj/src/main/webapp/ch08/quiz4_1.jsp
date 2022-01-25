<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>등록되었습니다</h1>
	<p>당신의 등록 이메일은 [<%=email%>] 입니다.</p>
</body>
</html>