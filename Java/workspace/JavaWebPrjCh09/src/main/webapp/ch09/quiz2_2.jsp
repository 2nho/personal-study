<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String grade = request.getParameter("grade");
	String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" name="grade" id="grade" value="<%=grade%>"/>
	<form action="./quiz2_3.jsp">
		<label for="title">제목:</label><input type="text" id="title" name="title" />
		<label for="content">내용:</label><textarea name="content" id="content" cols="30" rows="10"></textarea>
		<button id="update">수정</button>
	</form>
	
	<script>
		document.getElementById("update").addEventListener("click", function(e){
			e.preventDefault();
			let grade = document.getElementById("grade").value;
			if(grade <= 3){
				alert("<%=id%>의 수정권한이 너무 낮습니다.");
			}else{
				location.href = "./quiz2_3.jsp";
			}
		});
	</script>
</body>
</html>