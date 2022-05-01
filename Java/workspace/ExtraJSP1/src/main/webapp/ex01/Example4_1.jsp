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
		// pageContext : 자기 페이지 내에서만 생존
		String str1 = (String)pageContext.getAttribute("str1");
		String str2 = (String)request.getAttribute("str2");
		String str3 = (String)session.getAttribute("str3");
		String str4 = (String)application.getAttribute("str4");
	%>
	
	<p>pageContext str1 : <%=str1 %></p>
	<p>request str2 : <%=str2 %></p>
	<p>session str3 : <%=str3 %></p>
	<p>application str4 : <%=str4%></p>
</body>
</html>