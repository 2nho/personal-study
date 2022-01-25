<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int price1_1 = 10200;
	int price1_2 = 15000;
	int price1_3 = 20000;
	
	int green1 = 0;
	
	if((price1_1 < price1_2)&&(price1_1 < price1_3)){
		green1 = 1;
	}else if((price1_2 < price1_1)&&(price1_2 < price1_3)){
		green1 = 2;
	}else {
		green1 = 3;
	}
	
	int price2_1 = 14000;
	int price2_2 = 7500;
	int price2_3 = 13000;
	
	int green2 = 0;
	
	if((price2_1 < price2_2)&&(price2_1 < price2_3)){
		green2 = 1;
	}else if((price2_2 < price2_1)&&(price2_2 < price2_3)){
		green2 = 2;
	}else {
		green2 = 3;
	}
	
	int price3_1 = 3500;
	int price3_2 = 5000;
	int price3_3 = 7000;
	
	int green3 = 0;
	
	if((price3_1 < price3_2)&&(price3_1 < price3_3)){
		green3 = 1;
	}else if((price3_2 < price3_1)&&(price3_2 < price3_3)){
		green3 = 2;
	}else {
		green3 = 3;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 30px;
	font: 1rem "맑은 고딕", sans-serif; 
}

h1, h2{
	color: blue;
}

caption {
	background-color : cyan;
	font-weight : bold;
	padding : 5px;
}

tfoot {
	background : #ff6666;
	font-weight : bold;
	text-align: right;
}

table, tr, td, th {
	border : 1px solid black;
	border-collapse: collapse;
}

th, td {
	font-size : 10px;
	padding : 8px 15px; 
}

th {
	background-color : yellow
}

tbody tr:nth-child(1) td:nth-of-type(<%=green1%>){
	background-color: yellowgreen;
}

tbody tr:nth-child(2) td:nth-of-type(<%=green2%>){
	background-color: yellowgreen;
}

tbody tr:nth-child(3) td:nth-of-type(<%=green3%>){
	background-color: yellowgreen;
}
</style>
</head>
<body>
	<table>
		<caption>2021년 하반기 월별 경비 집계 표</caption>
		<thead>
			<tr>
				<th>구분</th>
				<th>7월</th>
				<th>8월</th>
				<th>9월</th>
				<th>합계</th>
				<th>평균</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>합계</th>
				<td><%=price1_1+price2_1+price3_1 %></td>
				<td><%=price1_2+price2_2+price3_2 %></td>
				<td><%=price1_3+price2_3+price3_3 %></td>
				<td><%=price1_1+price2_1+price3_1+price1_2+price2_2+price3_2+price1_3+price2_3+price3_3 %></td>
				<td><%=(price1_1+price2_1+price3_1+price1_2+price2_2+price3_2+price1_3+price2_3+price3_3)/9 %></td>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<th>전시장 대여료</th>
				<td><%=price1_1 %></td>
				<td><%=price1_2 %></td>
				<td><%=price1_3 %></td>
				<td><%=price1_1+price1_2+price1_3 %></td>
				<td><%=(price1_1+price1_2+price1_3)/3 %></td>
			</tr>
			<tr>
				<th>전시 물품 구입</th>
				<td><%=price2_1 %></td>
				<td><%=price2_2 %></td>
				<td><%=price2_3 %></td>
				<td><%=price2_1+price2_2+price2_3 %></td>
				<td><%=(price2_1+price2_2+price2_3)/3 %></td>
			</tr>
			<tr>
				<th>작품 재료 구입</th>
				<td><%=price3_1 %></td>
				<td><%=price3_2 %></td>
				<td><%=price3_3 %></td>
				<td><%=price3_1+price3_2+price3_3 %></td>
				<td><%=(price3_1+price3_2+price3_3)/3 %></td>
			</tr>
		</tbody>
	</table>
</body>
</html>

