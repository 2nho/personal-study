<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/ch07/example1_1.jsp">
		<ul>
			<li><label for="sel1">선택1</label><input type="checkbox" name="sel" id="sel1" value="sel1" /></li>
			<li><label for="sel2">선택2</label><input type="checkbox" name="sel" id="sel2" value="sel2" /></li>
			<li><label for="sel3">선택3</label><input type="checkbox" name="sel" id="sel3" value="sel3" /></li>
			<li><button>전송</button></li>
		</ul>
	</form>
</body>
</html>