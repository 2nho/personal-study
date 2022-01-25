<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Example5ServletController" method="post">
		<ul>
			<li><label for="id">아이디:</label><input type="text" id="id" name="id" /></li>
			<li><label for="pw">패스워드:</label><input type="password" name="pw" id="pw" /></li>
			<li><button>전송</button></li>
		</ul>
	</form>
</body>
</html>