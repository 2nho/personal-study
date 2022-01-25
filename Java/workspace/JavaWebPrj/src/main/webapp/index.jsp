<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num1 = "1234";
	int num1_1 = Integer.parseInt(num1);
	int num2_2 = num1_1+11;
	
	String num2 = "12.45";
	double d1 = Double.parseDouble(num2);
	double d2 = d1 + 11.11;
	
	Math.round(d2);
	Math.floor(d2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요</h1>
	<h2><%=num2_2%></h2>
	<h2><%=d2%></h2>
	<script type="text/javascript">
		console.log("이것은 jsp 파일에서 나오는 javascript!");
	</script>
</body>
</html>