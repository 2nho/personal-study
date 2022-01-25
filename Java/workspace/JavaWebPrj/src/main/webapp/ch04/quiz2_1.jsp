<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String heading = request.getParameter("heading");
	String profile = request.getParameter("profile");
	String name = request.getParameter("name");
	String major = request.getParameter("major");
	String desc = request.getParameter("desc");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.snip {
	font-family : "Roboto",Arial,sans-serif;
	position : relative;
	overflow : hidden;
	margin : 10px;
	min-width : 230px;
	max-width : 315px;
	width : 100%;
	color : white;
	text-align : left;
	line-height : 1.4rem;
	background-color : #141414;
}

.snip * {
	box-sizing : border-box;
	transition : all 0.25s ease;
}

.snip img {
	max-width : 100%;
	vertical-align : top;
	opacity : 0.85;
}

.snip .desc {
	width : 100%;
	background-color : #141414;
	padding : 25px;
	position : relative;
}

.snip .desc::before{
	position : absolute;
	content : "";
	bottom : 100%;
	left : 0;
	width : 0;
	height : 0;
	border-style : solid;
	border-width : 55px 0 0 400px;
	border-color : transparent transparent transparent #141414;
}

.snip .desc a {
	padding : 5px;
	border : 1px solid #ffffff;
	font-size : 0.7rem;
	text-transform : uppercase;
	margin : 10px 0;
	display : inline-block;
	opacity : 0.65;
	width : 47%;
	text-align : center;
	text-decoration : none;
	font-weight : 600;
	letter-spacing : 1px;
}

.snip .desc a:hover {
	opacity : 1;
}

.snip .profile {
	border-radius : 50%;
	position : absolute;
	bottom : 100%;
	left : 25px;
	z-index : 1;
	max-width : 90px;
	opacity : 1;
	box-shadow : 0 0 15px rgba(0,0,0,0.3);	
}

.snip .follow, .snip .info{
	margin-right : 4%;
	border-color : #2980b9;
	color : #2980b9;
}

.snip h2 {
	margin : 0 0 5px;
	font-weight : normal; 
}

.snip h2 span {
	display:block;
	font-size: 0.5rem;
	color : #2980b9;
}
.snip p {
	margin : 0 0 10px;
	font-size : 0.8rem;
	letter-spacing : 1px;
	opacity : 0.8;
}
</style>
</head>
<body>
	<div class="snip">
		<img src="<%=heading%>" alt="" />
		<div class="desc">
			<img alt="" src="<%=profile%>" class="profile">
			<h2>
				<%=name %><span><%=major%></span>
			</h2>
			<p><%=desc%></p>
			<a href="" class="follow">Follow</a><a href="" class="info">More Info</a>
		</div>
	</div>
</body>
</html>