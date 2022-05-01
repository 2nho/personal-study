<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//include : 페이지를 외부로부터 불러오는 연산
//directive include: 디렉티브 인클루드 => 디렉티브 형태로 페이지를 개발하는 방식
//action include: 액션 태그 인클루드 => 액션 태그를 사용하여 페이지를 별도로 개발하는 방식

// directive include식 개발
	String header = "이것은 헤더에 들어가는 내용입니다.";
	String footer = "이것은 푸터에 들어가는 내용입니다.";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<!--<h1>제목이 되는 헤더</h1>-->
<%@ include file="directive-header.jsp"%>
	</header>
	<main>
		<section>
			<article>이것은 내용</article>
		</section>
	</main>
	<footer>
		<!-- <p>이곳이 footer 부분</p> -->
<%@ include file="directive-footer.jsp"%>
	</footer>
</body>
</html>