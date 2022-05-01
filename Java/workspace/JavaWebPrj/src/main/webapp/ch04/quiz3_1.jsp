<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String price = request.getParameter("price");
	String saving = request.getParameter("saving");
	
	double d = Double.parseDouble(saving);
	// 소수점 두자리까지 버림
	saving = String.format("%.2f", d);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.plan-item {
	background-color : #fff;
	border-radius : 10px;
	height : 95%;
}

.plan-item:hover {
	animation: background-color-fix;
	animation-fill-mode : forward;
	animation-duration : 0.1s;
}

@keyframes background-color-fix {
	100% {
		background-color : #AEEA00;
	}
}

@media (max-width : 800px) {
	.plan-item {
		width : 362px;
		margin : 10px 0 10px 0;
	}
}


.choose-header {
	font-size : 2.4rem;
	color : crimson;
}

@media (max-width : 1180px) {
	.choose-header {
		margin: 10px 0 0 0;
		font-size : 1.9rem;
	}
}

.price, .price-description {
	color : black;
}
</style>
</head>
<body>
	<a class="plan-item" href="#">
		<h3 class="choose-header"><%=name%></h3>
		<p class="price">
			<strong>$<%=price%></strong>
		</p>
		<p class="price-description">
			(당신은 매년 $<%=saving%>를 절약할 수 있습니다.)
		</p>
	</a>
</body>
</html>