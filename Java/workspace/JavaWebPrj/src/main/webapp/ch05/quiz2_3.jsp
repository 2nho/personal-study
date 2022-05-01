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
	background-color: #ddd;
}
main {
	flex : 5;
}
header {
	background-color: yellowgreen;
	height : 100px;
}
.inner {
	display : flex;
}
.inner section {
	flex : 4;
}
.inner aside {
	flex : 1;
	background-color: #ddd;
}
.inner section article {
	background-color: #ccc;
	height : calc(100vh - 200px);
}
footer {
	background-color: gray;
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
			<div class="inner">
				<section>
					<article>Article</article>
					<footer>footer</footer>	
				</section>
				<aside>Aside</aside>
			</div>
		</main>
	</div>
</body>
</html>