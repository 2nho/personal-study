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
	Cookie[] cookies = request.getCookies();

	String str1 = null;
	
	for(Cookie cookie:cookies){
		if(cookie.getName().equals("str1")){
			str1 = cookie.getValue();
		}
	}
%>
<p>str1 : <%=str1 %></p>
</body>
</html>

