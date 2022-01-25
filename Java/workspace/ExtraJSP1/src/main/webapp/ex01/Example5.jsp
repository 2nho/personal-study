<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// forward 액션 태그
	/*
		- forward 액션 태그는 forward 형태로 사용자에게 요청에 대한 응답을 보내고자 할 경우 사용
		- 일반 태그처럼 forward를 웹페이지에 사용하기 위해서 액션태그 형태로 jsp에서 제공한다.
		- forward 태그는 jsp:forward 형태로 태그를 쓸 수가 있으며 page라는 속성에 내가 이동하고자
		  원하는 페이지의 주소를 적어 이동을 시킬 수 있다.
		- jsp:forward 내에는 jsp:param 이라는 태그를 사용할 수 있는데 request.getParameter를 통해
		  받을 수 있는 데이터의 이름과 값을 받아 선언이 가능하다.
	*/
%>
	<jsp:forward page="./Example5_1.jsp">
		<jsp:param value="100" name="test1"/>
		<jsp:param value="200" name="test2"/>
	</jsp:forward>
</body>
</html>