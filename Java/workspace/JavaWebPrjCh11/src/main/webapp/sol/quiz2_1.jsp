<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요</h1>
	<h3>당신의 평균 점수는 ${(vo.guk+vo.eng+vo.math)/3} 입니다.</h3>
	<c:choose>
		<c:when test="${(vo.guk+vo.eng+vo.math)/3 >= 90}">
			<h3>당신의 등급은 A 등급 입니다.</h3>
		</c:when>
		<c:when test="${(vo.guk+vo.eng+vo.math)/3 >= 80}">
			<h3>당신의 등급은 B 등급 입니다.</h3>
		</c:when>
		<c:when test="${(vo.guk+vo.eng+vo.math)/3 >= 70}">
			<h3>당신의 등급은 C 등급 입니다.</h3>
		</c:when>
		<c:when test="${(vo.guk+vo.eng+vo.math)/3 >= 60}">
			<h3>당신의 등급은 D 등급 입니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>당신의 등급은 F 등급 입니다.</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>