<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String footer = request.getParameter("footer");
%>
<p>이곳이 footer 부분</p>
<h2><%=footer%></h2>