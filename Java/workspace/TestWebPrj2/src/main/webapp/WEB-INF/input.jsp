<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/PutListController" method="post">
		<label for="title">제목 : </label>
		<input type="text" id="title" name="title"><br>
		<label for="content">내용 : </label>
		<textarea cols="30" rows="10" name="content" id="content">
		</textarea>
		<br>
		<button>전송</button>	
	</form>
</body>
</html>