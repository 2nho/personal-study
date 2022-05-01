<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<a href="test1">basic controller1</a><br />
	<a href="test2">basic controller2</a><br />
	<a href="test3">basic controller3</a><br />
	<a href="test4">basic controller4</a><br />
	<a href="test5" id="a5">rest controller5</a><br />
	<a href="test6" id="a6">rest controller6</a><br />
	<a href="test7" id="a7">rest controller7</a><br />
	<a href="test8" id="a8">rest controller8</a><br />
	<a href="test9" id="a9">rest controller9</a><br />
	<div id="result">
	</div>
	<script type="text/javascript">
		$(function(){
			$("#a5").click(function(e){
				e.preventDefault();
				$.ajax({
					url:"test5",
					type:"GET",
					contentType:"application/json; charset=utf-8;",
					dataType: "json",
					success: function(data){
						/* $("#result").text(JSON.stringify(data)); */
						$("#result").text(data[0].data1+","+data[0].data2);
					},
					error: function(){
						alert("stringify error");
					}
				});
			});
			
			$("#a6").click(function(e){
				e.preventDefault();
				$.ajax({
					url:"test6",
					type:"GET",
					contentType:"application/json; charset=utf-8;",
					dataType: "json",
					success: function(data){
						$("#result").text(JSON.stringify(data));
					},
					error: function(){
						alert("stringify error");
					}
				});
			});
			
			$("#a7").click(function(e){
				e.preventDefault();
				$.ajax({
					url:"test7",
					type:"PUT",
					contentType:"application/json; charset=utf-8;",
					dataType: "json",
					success: function(data){
						$("#result").text(JSON.stringify(data));
					},
					error: function(){
						alert("stringify error");
					}
				});
			});
			
			const sample_data = {data1:"데이터1",data2:"데이터2",data3:"데이터3"};
			
			$("#a8").click(function(e){
				e.preventDefault();
				$.ajax({
					url:"test8",
					type:"POST",
					data: JSON.stringify(sample_data),
					contentType:"application/json; charset=utf-8;",
					dataType: "json",
					success: function(data){
						$("#result").text(JSON.stringify(data));
					},
					error: function(){
						alert("stringify error");
					}
				});
			});
			
			$("#a9").click(function(e){
				e.preventDefault();
				$.ajax({
					url:"test9",
					type:"POST",
					data: JSON.stringify(sample_data),
					contentType:"application/json; charset=utf-8;",
					dataType: "json",
					success: function(data){
						$("#result").text(JSON.stringify(data));
					},
					error: function(){
						alert("stringify error");
					}
				});
			});
			
		});
	</script>
</body>
</html>