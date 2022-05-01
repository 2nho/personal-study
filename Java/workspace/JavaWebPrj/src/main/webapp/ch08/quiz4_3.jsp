<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String time = request.getParameter("time");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String major = request.getParameter("major");
	String gender = request.getParameter("gender");
	String[] favor = request.getParameterValues("favor");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수강신청이 완료되었습니다</h1>
	<h2>수강 희망 시간 : <%=time%></h2>
	<h2>수강자 : <%=name%></h2>
	<h2>이메일 : <%=email %></h2>
	<h2>전공 : <%=major %></h2>
	<h2>성별 : <%=((gender.equals("m"))?"남성":"여성") %></h2>
	<%for(String f : favor){ %>
	<h2>관심사 : <%=f %></h2>
	<%} %>
</body>
</html>