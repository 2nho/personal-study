<%@page import="kr.co.goodee39.beans.ExampleBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	ExampleBean bean = (ExampleBean)request.getAttribute("bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Example3.jsp 결과 페이지</h1>
	<h2>data1 : <%=bean.getData1() %></h2>
	<h2>data2 : <%=bean.getData2() %></h2>
</body>
</html>