<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String locale = "2n+1";
	String bgColor = "blue";
	String fontColor = "white";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container {
		text-align : center;
		color : #2b2b2b;
	}
	table {
		width : 200px;
		margin : 0 auto;
		border-collapse : collapse;
	}
	td {
		text-align: left;
		padding : 10px;
		padding-left : 20px;
	}
	
	table tr:nth-child(<%=locale%>){
		background-color : <%=bgColor%>;
		color : <%=fontColor%>;
	}
</style>
</head>
<body>
	<div id="container">
		<h1>건강에 좋은 식품</h1>
		<table border="1">
			<tr><td>블루베리</td></tr>
			<tr><td>귀리</td></tr>
			<tr><td>토마토</td></tr>
			<tr><td>시금치</td></tr>
			<tr><td>견과류</td></tr>
			<tr><td>포도주</td></tr>
			<tr><td>브로컬리</td></tr>
			<tr><td>마늘</td></tr>
			<tr><td>녹차</td></tr>
			<tr><td>자두주스</td></tr>
			<tr><td>사과</td></tr>
		</table>
	</div>
</body>
</html>