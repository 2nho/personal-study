<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul, li {
	list-style-type: none;
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/SearchResultController">
		<ul>
			<li>
				<p>잃어버린 아이디를 입력해주세요</p>
			</li>
			<li>
				<label for="id">아이디 : </label>
				<input type="text" id="id" name="id" />
			</li>
			<li>
				<button>찾기</button>
			</li>
		</ul>
	</form>
</body>
</html>


