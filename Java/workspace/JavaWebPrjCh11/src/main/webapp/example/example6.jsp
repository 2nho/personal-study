<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<String> list = new ArrayList<String>();
	list.add("aaa");
	list.add("bbb");
	list.add("ccc");
	
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- forEach => for --%>
	<%-- <c:forEach var="현재 아이템의 변수명" begin="시작값" end="종료값" 
	step="증가값" varStatus="반복 상태 값을 지닌 변수"> --%>
	<c:forEach var="i" begin="0" end="10" step="2" varStatus="x">
		<p> i = ${i} , i*i= ${i * i} <c:if test="${x.last}">, last = ${i}</c:if> </p>
	</c:forEach>
	
	<%-- <c:forEach var="현재 아이템의 변수명" items="반복할 데이터가 있는 아이템" 
	varStatus="반복 상태 값을 지닌 변수"> --%>
	<c:forEach var="s" items="${list}" varStatus="x">
		<p>${s}</p>
	</c:forEach>
</body>
</html>