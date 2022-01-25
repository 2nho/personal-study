<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = (String)request.getAttribute("id");
	Boolean bool = (Boolean)request.getAttribute("flag");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인증되었습니다.</h1>
	<h3>아이디 : <%=id%></h3>
	<% if(bool){ %>
	<h3>일치되었습니다</h3>
	<% }else{ %>
	<h3>불일치되었습니다.</h3>
	<% } %>
</body>
</html>