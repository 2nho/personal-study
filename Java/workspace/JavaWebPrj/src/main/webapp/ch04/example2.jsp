<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
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
		<jsp:include page="action-header.jsp">
			<jsp:param value="<%=header%>" name="header"/>
		</jsp:include>
	</header>
	<main>
		<section>
			<article>이것은 내용</article>
		</section>
	</main>
	<footer>
		<jsp:include page="action-footer.jsp">
			<jsp:param value="<%=footer%>" name="footer"/>
		</jsp:include>
	</footer>
</body>
</html>