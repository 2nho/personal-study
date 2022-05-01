<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Quiz202Controller">
		<fieldset>
			<legend>주문내용</legend>
			<ul>
				<li>
					<label for="menu">메뉴 : </label>
					<select name="menu" id="menu">
						<option value="2000">아메리카노</option>
						<option value="1500">아이스티</option>
						<option value="3500">아포가또</option>
					</select>
				</li>
				<li>
					<label for="num">수량 : </label>
					<input type="number" name="num" id="num" />
				</li>
				<li>
					<button>완료</button>
					<button type="button" id="back">뒤로가기</button>
				</li>
			</ul>
		</fieldset>
	</form>
	<script type="text/javascript">
		document.getElementById("back").addEventListener("click", function(){
			location.href = "<%=request.getContextPath()%>/Quiz200Controller";
		});
	</script>
</body>
</html>