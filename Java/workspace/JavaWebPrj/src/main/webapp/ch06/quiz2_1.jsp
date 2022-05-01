<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int v = Integer.parseInt(request.getParameter("v"));
	int h = Integer.parseInt(request.getParameter("h"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td {
	border : 1px solid black;
	border-collapse : collapse;
	font-size : 1.5rem;
	font-weight : bold;
}
</style>
</head>
<body>
	<table>
		<%for(int i = 1 ; i <= h ; i++){ %>
		<tr>
		<%for (int j = 1; j <= v ; j++){ %>
			<td><%=i %>-<%=j %></td>
		<%} %>
		</tr>
		<%} %>
	</table>	
</body>
</html>