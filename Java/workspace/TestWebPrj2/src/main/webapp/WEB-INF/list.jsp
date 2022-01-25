<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
thead tr {
	background-color: ActiveCaption;
	color: CaptionText;
}

th, td {
	vertical-align: top;
	font-family: "맑은 고딕", Arial, Helvetica, sans-serif;
	font-size: 9pt;
	padding: 3px;
}

table, td {
	border: 1px solid silver;
}

table {
	border-collapse: collapse;
}

thead .col0 {
	width: 58px;
}

.col0 {
	text-align: right;
}

thead .col1 {
	width: 87px;
}

thead .col2 {
	width: 71px;
}

thead .col3 {
	width: 101px;
}

thead .col4 {
	width: 154px;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th class="col0">id</th>
				<th class="col1">title</th>
				<th class="col2">owner</th>
				<th class="col3">createdate</th>
				<th class="col4">content</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td class="col0">${item.id}</td>
					<td class="col1">${item.title}</td>
					<td class="col2">${item.owner}</td>
					<td class="col3">${item.createdate}</td>
					<td class="col4">${item.content}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button id="btn">생성</button>
	<!-- <script src="../js/jquery-3.6.0.min.js"></script> -->
	<script>
		/* $(function(){
			$("#btn").click(function(){
				this.attr("disable", true);
				location.href = "${pageContext.request.contextPath}/MoveToInsertPage";		
			});
		}); */
		
		document.getElementById("btn").addEventListener("click", function(){
			this.disable = true;
			location.href = "${pageContext.request.contextPath}/MoveToInsertPage";
		});
	</script>
</body>
</html>


