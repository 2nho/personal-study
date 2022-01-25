<%@page import="kr.co.goodee39.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="loginbean" class="kr.co.goodee39.beans.LoginBean" scope="request"/>
<jsp:setProperty name="loginbean" property="id" value="qwer"/>
<%
	//LoginBean lb = new LoginBean();
	//loginbean.setId("qwer");
	//request.setAttribute("loginbean", lb);
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--<h2><%=loginbean.getId()%></h2>--%>
	<h2>
		<jsp:getProperty property="id" name="loginbean"/>
	</h2>
</body>
</html>