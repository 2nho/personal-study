<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="test/test1">test1</a><br />
	<a href="test/test2_get?str1=aaa">test2_get</a><br />
	<hr />
	<form action="test/test2_post" method="post">
		<label>id : <input type="text" id="id" name="id"></label><br />
		<label>pw : <input type="password" id="pw" name="pw"></label><br />
		<button>전송</button>
	</form>
	<hr />
	<form action="test/test3_post" method="post">
		<label>id : <input type="text" id="id" name="id"></label><br />
		<label>pw : <input type="password" id="pw" name="pw"></label><br />
		<button>전송</button>
	</form>
	<hr />
	<form action="test/test4_post" method="post">
		<label>id : <input type="text" id="id" name="id"></label><br />
		<label>pw : <input type="password" id="pw" name="pw"></label><br />
		<button>전송</button>
	</form>
	<hr />
	<form action="test/test5_post" method="post">
		<label>id : <input type="text" id="id" name="id"></label><br />
		<label>pw : <input type="password" id="pw" name="pw"></label><br />
		<label>name : <input type="text" id="name" name="name"></label><br />
		<label>addr : <input type="text" id="addr" name="addr"></label><br />
		<button>전송</button>
	</form>
	<hr />
	<form action="test/test6_post" method="post">
		<label>id : <input type="text" id="id" name="id"></label><br />
		<label>pw : <input type="password" id="pw" name="pw"></label><br />
		<label>name : <input type="text" id="name" name="name"></label><br />
		<label>addr : <input type="text" id="addr" name="addr"></label><br />
		<button>전송</button>
	</form>
</body>
</html>