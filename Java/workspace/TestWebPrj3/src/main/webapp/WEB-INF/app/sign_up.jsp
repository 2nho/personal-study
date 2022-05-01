<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul, li{
	list-style-type: none;
}
</style>
</head>
<body>
	<form id="form" action="${pageContext.request.contextPath}/SignUpResultController">
	<ul>
		<li>
			<label for="id">아이디 :</label>
			<input type="text" id="id" name="id" />
		</li>
		<li>
			<label for="pw">패스워드 : </label>
			<input type="password" name="pw" id="pw" />
		</li>
		<li>
			<label for="pwd">패스워드 확인 : </label>
			<input type="password" id="pwd" name="pwd" />
		</li>
		<li>
			<label for="name">이름 : </label>
			<input type="text" id="name" name="name" />	
		</li>
		<li>
			<button type="button" id="btn">등록</button>
		</li>
	</ul>
	</form>
	<script>
		const form = document.getElementById("form");
	
		document.getElementById("btn").addEventListener("click",function(e){		
			let pw = document.getElementById("pw").value;
			let pwd = document.getElementById("pwd").value;
			
			if(pw != pwd){
				alert("패스워드가 일치하지 않습니다.");
			}else{
				form.submit();
			}
		});
	</script>
</body>
</html>


