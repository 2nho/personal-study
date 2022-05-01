<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test2</h1>
	<form:form modelAttribute="userVO" action="result">
	이름 : <form:input path="name"/><br />
	아이디 : <form:input path="id"/><br />
	비밀번호 : <form:password path="pw" showPassword="true"/><br />
	우편번호 : <form:input path="postcode"/><br />
	주소1 : <form:input path="address1"/><br />
	주소2 : <form:input path="address2"/><br />
	<button>확인</button>
	</form:form>
</body>
</html>