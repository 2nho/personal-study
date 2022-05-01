<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	boolean b = false;
	request.setAttribute("b", b);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jstl if : 조건에 따라 화면을 선택적으로 보여주게 하는 커스텀 태그 -->
	<c:if test="${!b}"><a href="#">로그인</a></c:if>
	<c:if test="${b}"><a href="#">로그아웃</a></c:if>
	<br />
	<hr />
	<br />
	<!-- choose~when~otherwise -> if ~ else if ~ else -->
	<c:choose>
		<c:when test="${!b}">
			<a href="#">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="#">로그아웃</a>
		</c:otherwise>
	</c:choose>
</body>
</html>