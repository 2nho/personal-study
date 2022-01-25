<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container {
		display : flex;
	}
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="./Example6_header.jsp"/>
		<hr />
		<main>여기는 메인입니다</main>
		<hr />
		<jsp:include page="./Example6_footer.jsp"/>
	</div>
</body>
</html>