<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form" action="#">
		<fieldset>
			<legend>페이지 이동</legend>
			<ul>
				<li>
					<select name="num" id="num">
						<option value="1">1페이지</option>
						<option value="2">2페이지</option>
						<option value="3">3페이지</option>
					</select>
				</li>
				<li>
					<!--<button id="move" type="button">이동</button> -->
					<button id="move">이동</button>
				</li>
			</ul>
		</fieldset>
	</form>
	<script type="text/javascript">
		document.getElementById("move").addEventListener("click", function(e){
			/*
			let num = document.getElementById("num").value;
			if(num == "1"){
				location.href = "quiz2_1.jsp?num="+num;
			}else if(num == "2"){
				location.href = "quiz2_2.jsp?num="+num;
			}else{
				location.href = "quiz2_3.jsp?num="+num;
			}
			*/
			e.preventDefault();
			let num = document.getElementById("num").value;
			const form = document.getElementById("form");
			form.setAttribute("action", "quiz2_"+num+".jsp");
			form.submit();
		});
	</script>
</body>
</html>



