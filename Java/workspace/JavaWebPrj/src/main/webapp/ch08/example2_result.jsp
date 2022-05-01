<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
//	String data1 = (String)request.getAttribute("data1");
//	String data2 = (String)request.getAttribute("data2");
	String data1 = request.getParameter("data1");
	String data2 = request.getParameter("data2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>example2.jsp 결과 페이지입니다.</h1>
	<h2>data1 : <%=data1 %></h2>
	<h2>data2 : <%=data2 %></h2>
</body>
</html>