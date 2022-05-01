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
		// request -> setAttribute : 오브젝트를 키워드로 저장할 때 쓰는 메서드
		// request -> getAttribute : 오브젝트에 담긴 데이터를 가져올 때 쓰는 메서드
		
		request.setAttribute("id", "abcd");
		request.setAttribute("pw", "1234");
		
		// response.sendRedirect("example4_1.jsp");
		pageContext.forward("example4_1.jsp");
	%>
</body>
</html>