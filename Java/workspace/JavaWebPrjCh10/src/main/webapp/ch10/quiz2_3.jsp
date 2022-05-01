<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int amount = (Integer)request.getAttribute("amount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>현재 벌어들인 총 금액은 <span><%=amount%></span>원 입니다</h3>
</body>
</html>