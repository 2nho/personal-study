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
	<form:form modelAttribute="dataVO1" action="input_pro">
		data1 : <form:input path="column1" type="text"/>
		data2 : <form:input path="column2" type="text"/>
		data3 : <form:input path="column3" type="text"/>
		<form:button type="submit">확인</form:button>
	</form:form>
</body>
</html>