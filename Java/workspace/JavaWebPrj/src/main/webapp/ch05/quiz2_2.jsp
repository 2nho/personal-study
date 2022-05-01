<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin : 0;
	height : 100vh;
}
h1 {
	margin : 0;
}
.container {
	display : flex;
}
nav {
	flex : 1;
	background-color: #ddd
}
main {
	flex: 5;
}
header {
	background-color : teal;
	color : #fff;
	height : 100px;
}
section {
	display : flex;
}
section article,
section aside {
	height : calc(100vh - 200px);
}

section article {
	flex : 4;
	background-color: pink;
}

section aside {
	flex : 1;
	background-color: yellow;
}

footer {
	background-color: gray;
	color : #fff;
	height : 100px;
}
</style>
</head>
<body>
	<div class="container">
		<nav>Nav</nav>
		<main>
			<header>
				<h1><%=num%> page</h1>
			</header>
			<section>
				<article>Article</article>
				<aside>Aside</aside>
			</section>
			<footer>footer</footer>
		</main>
	</div>
</body>
</html>