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
	request.setAttribute("id", "abcd");
	request.setAttribute("pw", "1234");
%>
	<jsp:forward page="example5_1.jsp"></jsp:forward>
</body>
</html>