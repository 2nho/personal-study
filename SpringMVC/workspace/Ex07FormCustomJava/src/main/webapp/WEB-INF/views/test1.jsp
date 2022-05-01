<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<form action="result" method="post">
		이름 : <input type="text" name="name" value="${requestScope.userVO.name}" /><br />
		아이디 : <input type="text" name="id" value="${requestScope.userVO.id}" /><br />
		비밀번호 : <input type="text" name="pw" value="${requestScope.userVO.pw}" /><br />
		우편번호 : <input type="text" name="postcode" value="${requestScope.userVO.postcode}" /><br />
		주소1 : <input type="text" name="address1" value="${requestScope.userVO.address1}" /><br />
		주소2 : <input type="text" name="address2" value="${requestScope.userVO.address2}" /><br />
		<button>확인</button>
	</form>
</body>
</html>