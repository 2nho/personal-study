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
	<ul>
	<c:forEach var="obj" items="${list}">
		<li>${obj.column1}, ${obj.column2}, ${obj.column3}</li>
	</c:forEach>
	</ul>
</body>
</html>