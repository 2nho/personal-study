<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>평균구하기</h1>
	<form action="${pageContext.request.contextPath}/Quiz2Controller" method="post">
		<ul>
			<li><label for="guk">국어</label><input type="text" id="guk" name="guk" /></li>
			<li><label for="eng">영어</label><input type="text" id="eng" name="eng" /></li>
			<li><label for="math">수학</label><input type="text" id="math" name="math" /></li>
			<li><button>전송</button></li>
		</ul>
	</form>
</body>
</html>