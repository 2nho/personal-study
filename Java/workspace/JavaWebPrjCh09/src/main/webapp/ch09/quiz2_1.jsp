<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)request.getAttribute("id");
	String pw = (String)request.getAttribute("pw");
	int grade = (Integer)request.getAttribute("grade");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>데이터가 세팅되었습니다.</h1>
	<h2>게시판 수정으로 이동하세요</h2>
	<h3><a href="<%=request.getContextPath()%>/ch09/quiz2_2.jsp?id=<%=id%>&pw=<%=pw%>&grade=<%=grade%>">이동</a></h3>
</body>
</html>