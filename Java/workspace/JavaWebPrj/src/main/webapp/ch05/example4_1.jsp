<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
	%>
	
	<h1>example4_1.jsp에서 넘겨받은 데이터</h1>
	<p>id : <%=id%></p>
	<p>pw : <%=pw%></p>
</body>
</html>