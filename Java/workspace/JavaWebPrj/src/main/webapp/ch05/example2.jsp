<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/ExampleServletController" method="get">
		<label for="id">아이디 : </label>
		<input type="text" id="id" name="id"/>
		<br />
		<label for="pw">패스워드 : </label>
		<input type="password" name="pw" id="pw"/>
		<br />
		<button>전송</button>
	</form>
</body>
</html>