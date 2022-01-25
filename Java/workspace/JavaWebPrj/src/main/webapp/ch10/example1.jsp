<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Exam101Controller">
		<ul>
			<li><label for="data1">첫번째 수 : </label><input type="text" id="data1" name="data1" /></li>
			<li><label for="data2">두번째 수 : </label><input type="text" id="data2" name="data2" /></li>
			<li>
				<ul>
					<li><label for="plus">더하기</label><input type="radio" name="type" id="plus" value="plus" /></li>
					<li><label for="minus">빼기</label><input type="radio" name="type" id="minus" value="minus" /></li>
					<li><label for="mul">곱하기</label><input type="radio" name="type" id="mul" value="mul" /></li>
					<li><label for="div">나누기</label><input type="radio" name="type" id="div" value="div" /></li>
				</ul>
			</li>
			<li><button>결과 확인</button></li>
		</ul>
	</form>
</body>
</html>