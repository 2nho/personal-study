<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style-type : none;
}

.btn {
	box-sizing : border-box;
	border : 2px solid red;
	border-radius : 0.6rem;
	color : red;
	cursor : pointer;
	display : flex;
	align-self: center;
	font-size : 1rem;
	font-weight : 700;
	line-height : 1;
	margin : 20px;
	padding : 1.2rem 2.0rem;
	text-decoration : none;
	text-align : center;
	text-transform : uppercase;
}


</style>
</head>
<body>
	<ul>
		<li><button class="btn first" onclick="movepage('home')">HOME</button></li>
		<li><button class="btn first" onclick="movepage('공지사항')">공지사항</button></li>
		<li><button class="btn first" onclick="movepage('BBS')">BBS</button></li>
	</ul>
	
	<script>
		function movepage(str){
			location.href = "quiz1_1.jsp?title="+str;
		}
	</script>
</body>
</html>