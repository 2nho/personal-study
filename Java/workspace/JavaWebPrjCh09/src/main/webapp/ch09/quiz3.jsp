<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Quiz301Controller">
		<ul>
			<li><label for="id">ID : </label><input type="text" id="id" name="id" /></li>
			<li><label for="kind">들어있는 제품 : </label><input type="text" id="kind" name="kind" /></li>
			<li><label for="amount">수량 : </label><input type="text" id="amount" name="amount" /></li>
			<li><label for="origin">출발지 : </label><input type="text" id="origin" name="origin" /></li>
			<li><label for="des">도착지 : </label><input type="text" id="des" name="des" /></li>
			<hr>
			<li><label for="carnum">운송차량번호 : </label><input type="text" id="carnum" name="carnum" /></li>
			<li><label for="driver">운전사이름 : </label><input type="text" id="driver" name="driver" /></li>
			<li><label for="phone">연락처 : </label><input type="text" id="phone" name="phone" /></li>
			<hr>
			<li><label for="shipnum">배번호 : </label><input type="text" id="shipnum" name="shipnum" /></li>
			<li><label for="port">도착항구 : </label><input type="text" id="port" name="port" /></li>
			<hr>
			<li><label for="startair">출발공항 : </label><input type="text" id="startair" name="startair" /></li>
			<li><label for="desair">도착공항 : </label><input type="text" id="desair" name="desair" /></li>
			<hr>
			<li><label for="type">운송타입 : </label><input type="text" id="type" name="type" /></li>
			<li><button>버튼</button></li>
			<li></li>
		</ul>
	</form>
</body>
</html>