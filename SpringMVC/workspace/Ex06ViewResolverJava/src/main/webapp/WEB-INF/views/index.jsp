<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="test1?data1=100&data2=200">test1</a>
	<hr />
	<a href="test2">test2</a>
	<hr />
	<a href="test3">test3</a>
	<hr />
	<a href="test4">test4</a>
	<hr />
	<form action="test5" method="post">
		data1 : <input type="text" name="data1"/><br />
		data2 : <input type="text" name="data2"/><br />
		<button>전송</button>
	</form>
	<hr />
	<form action="test6" method="post">
		data1 : <input type="text" name="data1"/><br />
		data2 : <input type="text" name="data2"/><br />
		<button>전송</button>
	</form>
</body>
</html>