<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	// 선언부 (declaration)
	// 스크립트 릿
	// 익스프레션
 --%>
<%!
	// 선언부
	// - 클래스 및 변수, 메서드 선언 시 쓰는 부분
	class ExClass1{
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	 // 스크립트 릿
	 // - 동작할 로직을 정의할 때 쓰는 부분
	 String s1 = "안녕하세요";
%>
<%--
	익스프레션
	- 우리가 정의한 변수를 웹으로 출력할 때 쓰는 문장	
 --%>
 <h1><%=s1%></h1>
</body>
</html>







