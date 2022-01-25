<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String header = request.getParameter("header");
%>
<h1>제목이 되는 헤더</h1>
<h2><%=header%></h2>