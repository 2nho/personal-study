<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String color1 = "color:blue;";
	String color2 = "color:red;";
	String color3 = "green";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p {
	<%=color1%>
}
</style>
</head>
<body>
	<p>word1</p>
	<p>word2</p>
	<p style="<%=color2%>">word3</p>
	<p><font color="<%=color3%>">초록색 글자</font></p>
</body>
</html>