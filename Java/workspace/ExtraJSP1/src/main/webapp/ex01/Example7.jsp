<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./Example7_header.jsp">
		<jsp:param value="100" name="str1"/>
		<jsp:param value="200" name="str2"/>
	</jsp:include>
	<hr />
	<h1>여기는 메인입니다</h1>
	<hr />
	<jsp:include page="./Example7_footer.jsp">
		<jsp:param value="300" name="str1"/>
		<jsp:param value="400" name="str2"/>
	</jsp:include>
</body>
</html>