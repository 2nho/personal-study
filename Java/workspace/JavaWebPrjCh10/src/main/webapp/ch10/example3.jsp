<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Exam301Controller" method="post">
		<ul>
			<li><label for="deptno">deptno : </label><input type="text" id="deptno" name="deptno"/></li>
			<li><label for="dname">dname : </label><input type="text" id="dname" name="dname"/></li>
			<li><label for="loc">loc : </label><input type="text" id="loc" name="loc"/></li>
			<li><button>전송</button></li>
		</ul>
	</form>
</body>
</html>