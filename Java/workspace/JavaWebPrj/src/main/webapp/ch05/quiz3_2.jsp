<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String img = request.getParameter("img");
	String name = request.getParameter("name");
	String desc = request.getParameter("desc");
	String price = request.getParameter("price");
	String discount = request.getParameter("discount");
	String link = request.getParameter("link");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="snip">
		<img src="<%=img%>" alt="" />
		<div class="add-to-cart">
			<i></i><span>Add to Cart</span>
		</div>
		<div>
			<h3><%=name%></h3>
			<p><%=desc%></p>
			<div class="price">
				<s><%=price%></s><%=discount%>
			</div>
			<a href="quiz3_3.jsp?value=<%=link%>"></a>
		</div>
	</div>
</body>
</html>