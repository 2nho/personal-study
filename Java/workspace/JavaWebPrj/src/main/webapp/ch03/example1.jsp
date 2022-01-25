<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 스크립트 릿
// - 자바 소스를 JSP 안에다가 넣기 위해 사용되는 구문
	 String s1 = "안녕하세요";
	 String name = "홍길동";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요</h1>
	<!-- 익스프레션 : 자바에서 나온 변수를 웹에서 출력, 사용하기 위해 쓰는 문장 -->
	<h2><%=s1 %></h2>
	<h3>내 이름 : <%=name %></h3>
</body>
</html>