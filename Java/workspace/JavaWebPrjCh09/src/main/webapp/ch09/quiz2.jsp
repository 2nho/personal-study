<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Quiz201Controller">
		<fieldset>
			<legend>로그인</legend>
			<ul>
				<li><label for="id">아이디 : </label><input type="text" id="id" name="id" /></li>
				<li><label for="pw">패스워드 : </label><input type="text" id="pw" name="pw" /></li>
				<li><label for="grade">등급 : </label><input type="text" id="grade" name="grade" /></li>
			</ul>
		</fieldset>
		<div>
			<button type="submit">로그인</button>
			<button type="reset">리셋</button>
		</div>
	</form>
</body>
</html>