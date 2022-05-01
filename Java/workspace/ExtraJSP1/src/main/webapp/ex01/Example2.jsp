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
		// 내장객체의 종류
		// request : 사용자에 대한 요청 정보를 저장한 객체
		// response : 사용자의 요청에 대한 응답 정보를 저장한 객체
		// session : 클라이언트의 세션 정보를 저장한 객체
		// pageContext : 페이지 실행에 필요한 컨텍스트 정보를 저장한 객체
		// out : 응답 페이지 전송을 위한 출력 스트림을 가지고 있는 객체
		// application : 우리가 사용하고 있는 어플리케이션의 정보를 저장하고 있는 객체
		// config : 해당 페이지의 서블릿 설정 정보를 저장하는 객체
		// page : 해당 페이지의 서블릿 객체
		// exception : 예외 처리를 위한 객체
	%>
	
	<%-- request 객체 예제 --%>
	<a href="./Example2_1.jsp?test1=100&test2=200&test3=300&test3=400">이동</a>
</body>
</html>

