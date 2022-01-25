<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Example3ServletController" method="post">
		<ul>
			<li><label for="data1">데이타1</label><input type="text" id="data1" name="data1" /></li>
			<li><label for="data2">데이타2</label><input type="text" id="data2" name="data2" /></li>
			<li><button>전송</button></li>
		</ul>
	</form>
</body>
</html>