<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name="";
	String value="";
	Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for(int i=0; cookies.length > i; i++){
			cookies[i].setMaxAge(0);
	%>
	<h1><%=cookies[i].getName()%> : <%=cookies[i].getValue()%></h1>
	<%	
		}
	%>
</body>
</html>