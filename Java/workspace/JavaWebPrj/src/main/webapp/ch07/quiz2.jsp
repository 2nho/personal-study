<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="quiz2_1.jsp">
		<ul id="file-list">
			<li><label for="file1">파일추가</label><input type="file" name="file" id="file1" /></li>
		</ul>
		<button id="add" type="button">추가</button><button id="send">전송</button>
	</form>
	<script type="text/javascript">
		let cnt = 1;
		
		document.getElementById("add").addEventListener("click", function() {
			cnt++;
			const li = document.createElement("li");
			const label = document.createElement("label");
			label.setAttribute("for", ("file"+cnt));
			const labelText = document.createTextNode("파일추가");
			label.append(labelText);
			const input = document.createElement("input");
			input.setAttribute("type", "file");
			input.setAttribute("id", ("file"+cnt));
			input.setAttribute("name", "file");
			li.append(label);
			li.append(input);
			
			document.getElementById("file-list").append(li);
		}, false);
	</script>
</body>
</html>