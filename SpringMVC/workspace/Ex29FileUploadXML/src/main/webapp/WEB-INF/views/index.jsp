<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resource/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h3>단일 파일 업로드</h3>
	<form action="test1" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Select File</td>
				<td><input type="file" name="mediaFile"/> </td>
				<td>
					<button type="submit">Upload</button>
				</td>
			</tr>
		</table>
	</form>
	<hr />
	<h3>다중 파일 업로드</h3>
	<form action="test2" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Select File</td>
				<td><input type="file" name="mediaFile" multiple="multiple"/> </td>
				<td>
					<button type="submit">Upload</button>
				</td>
			</tr>
		</table>
	</form>
	<hr />
	<h3>파일 업로드 + 추가 정보</h3>
	<form action="test3" method="post" enctype="multipart/form-data">
		<label for="user">user : </label><input type="text" name="user" id="user"><br />
		<label for="url">url : </label><input type="text" name="url" id="url"/><br />
		<input type="file" name="mediaFile"/><br />
		<button type="submit">Upload</button>
	</form>
	<hr />
	<h3>파일 업로드 + 추가 정보2</h3>
	<form action="test4" method="post" enctype="multipart/form-data">
		<label for="user">user : </label><input type="text" name="user" id="user"><br />
		<label for="url">url : </label><input type="text" name="url" id="url"/><br />
		<input type="file" name="mediaFile"/><br />
		<button type="submit">Upload</button>
	</form>
	<hr />
	<h3>비동기 통신으로 업로드 하기</h3>
	<div class="upload-div">
		<input type="file" name="mediaFile" id="mediaFile" multiple="multiple"/>
	</div>
	<button id="btn1">Upload</button>
	
	<script type="text/javascript">
		$(function(){
			$("#btn1").click(function(){
				const formData = new FormData();
				const $inputFile = $("#mediaFile");
				let files = $inputFile[0].files;
				console.log(files);
				
				for(let i=0; i< files.length; i++){
					formData.append("uploadFile",files[i]);
				}
				
				$.ajax({
					url:"test5",
					processData : false,
					contentType : false,
					data : formData,
					type : "POST",
					success: function(result){
						console.log(result);
					}
				});
			});
		});
	</script>
	
	<hr />
	<a href="download">다운로드</a>
	<img src="upload/camping.jpg" alt="" />
</body>
</html>




























