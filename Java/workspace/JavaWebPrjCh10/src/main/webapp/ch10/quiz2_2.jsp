<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>완료되었습니다</h1>
	<button id="back">뒤로가기</button>
	<script type="text/javascript">
		document.getElementById("back").addEventListener("click", function(){
			location.href = "<%=request.getContextPath()%>/Quiz200Controller";
		});
	</script>
</body>
</html>