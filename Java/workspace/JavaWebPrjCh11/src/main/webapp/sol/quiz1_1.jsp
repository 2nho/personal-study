<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>어서오세요 ${param.name}님</h1>
	<h3>귀하의 성별은 ${(param.gender.equals("1"))?"남성":"여성"}입니다.</h3>
</body>
</html>