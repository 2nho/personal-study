<%@page import="kr.co.goodee39.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//LoginBean vo = (LoginBean)request.getAttribute("vo");
	
	RequestDispatcher rdp = request.getRequestDispatcher("/Example51ServletController");
	rdp.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <a href="<%=request.getContextPath()%>/Example51ServletController?id=<%=vo.getId()%>&pw=<%=vo.getPw()%>">이동</a> --%>
	<%--<jsp:forward page="/Example51ServletController">
		<jsp:param value="<%=vo.getId()%>" name="id"/>
		<jsp:param value="<%=vo.getPw()%>" name="pw"/>
	</jsp:forward>--%>
</body>
</html>