<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String media = "media/Kalimba.mp3";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<audio autoplay controls>
		<source src="<%=media%>" type="audio/mp3">
	</audio>
</body>
</html>