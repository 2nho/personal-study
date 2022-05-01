<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str1 = request.getParameter("str1");
	String str2 = request.getParameter("str2");
%>
<footer>
	<h1>여기는 푸터입니다.</h1>
	<h3>str1 : <%=str1 %></h3>
	<h3>str2 : <%=str2 %></h3>
</footer>