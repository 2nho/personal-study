<%@page import="kr.co.goodee39.vo.BBSVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	List<BBSVO> list = (List<BBSVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<table border="1">
		<%for(BBSVO vo : list){ %>
		<tr>
			<td><%=vo.getSid() %></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getOwner() %></td>
			<td><%=vo.getCreateDate() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>