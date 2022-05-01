<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Quiz101Controller">
		<fieldset>
			<legend>회원가입</legend>
			<ul>
				<li><label for="id">id : </label><input type="text" id="id" name="id" /></li>
				<li><label for="pw">password : </label><input type="text" id="pw" name="pw" /></li>
				<li><label for="cw">confirm password : </label><input type="text" id="cw" name="cw" /></li>
			</ul>
		</fieldset>
		<div>
			<button type="submit">submit</button>
			<button type="reset">reset</button>
		</div>
	</form>
</body>
</html>