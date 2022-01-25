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
header {
	background-color : pink;
	color : #000;
	/*text-align : center;*/
	height : 150px;
}

section {
	display : flex;
}

article, aside, nav {
	height : calc(100vh - 300px);
}

article {
	flex : 3;
	background-color: #eee;
}

aside {
	flex : 1;
	background-color : #ddd;
}

nav {
	flex : 1;
	background-color : #ccc;
}

footer {
	background-color : gray;
	color : #fff;
	height : 150px;
	text-align : center;
}

h1 {
	margin : 0;
}
</style>
</head>
<body>
	<div class="container">
		<header>
			<h1><%=num%> page</h1>
		</header>
		<section>
			<article>Article</article>
			<aside>Aside</aside>
			<nav>Nav</nav>
		</section>
		<footer>footer</footer>
	</div>
</body>
</html>