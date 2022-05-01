<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> <%=session.getAttribute("언어1")%></h3>
	<%
		if(session.getAttribute("언어1")!= null){
	%>
	<h3>인가된 사용자입니다.</h3>
	<%
		}else{	
	%>
	<h3>인가된 사용자가 아닙니다.</h3>
	<%} %>
	
	<%
		session.invalidate();
	%>
</body>
</html>