<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="quiz1_1.jsp">
		<label for="name">이름 : </label>
		<input type="text" id="name" name="name" />
		<br />
		<label for="male">남자 : </label>
		<input type="radio" name="gender" id="male" value="1" />
		<br />
		<label for="female">여자 : </label>
		<input type="radio" name="gender" id="female" value="2" />
		<br />
		<button>전송</button>
	</form>
</body>
</html>