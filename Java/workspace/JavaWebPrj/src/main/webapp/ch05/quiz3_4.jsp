<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String img = request.getParameter("img");
	String name = request.getParameter("name");
	String desc = request.getParameter("desc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background : url("<%=img%>") no-repeat center;
	background-size : cover;
}
h1, p {
	color : #f1f1f1;
}

</style>
</head>
<body>
	<h1><%=name %></h1>
	<p><%=desc %></p>
</body>
</html>