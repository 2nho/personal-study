<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// include
	/*
	-- 디렉티브 인클루드
	  => page include...
	-- 액션태그 인클루드
	  => <jsp:include
	*/
	
	// forward
	/*
	 -- jsp:forward
	 -- RequestDispatcher rdp = .....
	*/
	
	// redirect
	/*
	 -- location.href
	 -- response.sendRedirect
	*/
	
	String aaa = "aaa데이터";
	String bbb = "bbb데이터";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--<%@ include file="example3_1.jsp" %> --%>
	<jsp:include page="example3_1.jsp">
		<jsp:param value="<%=aaa%>" name="aaa"/>
		<jsp:param value="<%=bbb%>" name="bbb"/>
	</jsp:include>
</body>
</html>




