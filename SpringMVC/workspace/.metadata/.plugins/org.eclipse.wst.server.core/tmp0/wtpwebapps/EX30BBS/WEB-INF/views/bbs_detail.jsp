<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>bbs 상세 페이지</h1>
	<h1>제목 : ${bbsVO.title}</h1>
	<h3>글쓴이 : ${bbsVO.ownername}</h3>
	<hr />
	<h3>내용 : </h3>
	<p>${bbsVO.content}</p>
	<hr />
	<c:forEach var="file" items="${filelist}">
		<a href="${pageContext.request.contextPath}/downloadFile/${file.localName}/${file.serverName}">${file.localName}</a><br>
	</c:forEach>
	<hr />
	<c:if test="${sessionScope.account.id == bbsVO.ownerid }">
		<button id="modify">수정</button>
		<button id="delete">삭제</button>
	</c:if>
	<%-- <a href="${pagaContext.request.contextPath}/bbs/modify_bbs?num=${bbsVO.num}">수정</a>
	<a href="${pagaContext.request.contextPath}/bbs/delete_bbs?num=${bbsVO.num}">삭제</a> --%>
	<hr />
	<div id="comment-list">
		
	</div>
	<hr />
	<div>
		<textarea name="comment" id="comment" cols="200" rows="5"></textarea>
		<button id="set-comment">추가</button>
	</div>
	<hr />
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/comment/get/${bbsVO.num}",
				type:"GET",
				dataType : "json",
				success : function(data){
					//console.log(data);
					for(const item of data){
						//$("#comment-list").append("<div><h3>"+item.writername+"</h3><p>"+item.comment
						//		+"</p></div><button class='comment-delete'>삭제</button>");
						let usernum = ${sessionScope.account.num};
						
						const commentList = document.querySelector("#comment-list");
						
						const div = document.createElement("div");
						const h3 = document.createElement("h3");
						h3.innerText = item.writername;
						const p = document.createElement("p");
						p.innerText = item.comment;
						
						// 해당 유저가 쓴 댓글일 경우
						if(usernum == item.writernum){
							// 삭제 버튼
							const delete_button = document.createElement("button");
							delete_button.innerText = "삭제";
						
							delete_button.addEventListener("click", function(){
								//alert("삭제되었습니다");
								let yn = confirm("삭제하시겠습니까?");
								//console.log(yn);
								if(yn){
									let comment_data = {num:item.num};
									
									$.ajax({
										url:"${pageContext.request.contextPath}/comment/delete",
										type:"DELETE",
										data:JSON.stringify(comment_data),
										contentType : "application/json; charset=utf-8",
										dataType : "html",
										success:function(data){
											div.remove();
										}
									});
								}
							});
							
							div.append(delete_button);
							
							// 수정 버튼
							const modify_button = document.createElement("button");
							modify_button.innerText = "수정";
							
							modify_button.addEventListener("click", function(){
								const edit_div = document.createElement("div");
								const edit_textarea = document.createElement("textarea");
								edit_textarea.cols = "200";
								edit_textarea.rows = "5";
								
								edit_textarea.value = p.innerText;
								
								const edit_modify = document.createElement("button");
								edit_modify.innerText = "수정완료";
								const edit_cancel = document.createElement("button");
								edit_cancel.innerText = "취소";
								
								edit_div.append(edit_textarea);
								edit_div.append(edit_modify);
								edit_div.append(edit_cancel);
								
								div.after(edit_div);
								div.style.display = "none";
								
								// 취소 버튼 클릭 시 이벤트
								edit_cancel.addEventListener("click", function(){
									div.style.display = "block";
									edit_div.remove();
								});
								
								// 수정완료 버튼 클릭 시 이벤트
								edit_modify.addEventListener("click", function(){
									//alert("수정완료 버튼 클릭");
									if(confirm("수정하시겠습니까")){
										let comment = edit_textarea.value;
										
										const modify_data = {comment, num:item.num};
										
										$.ajax({
											url:"${pageContext.request.contextPath}/comment/update",
											type:"PATCH",
											data:JSON.stringify(modify_data),
											contentType : "application/json; charset=utf-8",
											dataType : "json",
											success:function(data){
												console.log(data);
												p.innerText = data.comment;
												div.style.display = "block";
												edit_div.remove();
											}
										});
									}
								});
							});
							
							div.append(modify_button);
						}
						
						div.prepend(p);
						div.prepend(h3);
						
						
						commentList.append(div);
					}
				}
			});
			
			//$(document).on("click",".comment-delete",function(){
			//	alert("삭제되었습니다");
			//});
			
			$("#delete").click(function(){
				if(confirm("정말로 삭제하시겠습니까")){
					location.href = "${pageContext.request.contextPath}/bbs/delete_bbs?num=${bbsVO.num}";
				}
			});
			$("#modify").click(function(){
				location.href ="${pageContext.request.contextPath}/bbs/modify_bbs?num=${bbsVO.num}";
			});
			$("#set-comment").click(function(){
				let comment = $("#comment").val();
				//console.log(comment);
				//console.log(comment.length);
				
				if(comment.length > 0){
					let comment_data = {comment, bnum :"${bbsVO.num}"};
					
					$.ajax({
						url:"${pageContext.request.contextPath}/comment/set",
						type:"POST",
						data:JSON.stringify(comment_data),
						contentType : "application/json; charset=utf-8",
						dataType : "json",
						success:function(data){
							let usernum = data.writernum;
							
							const commentList = document.querySelector("#comment-list");
							
							const div = document.createElement("div");
							const h3 = document.createElement("h3");
							h3.innerText = data.writername;
							const p = document.createElement("p");
							p.innerText = data.comment;
							
							// 삭제 버튼
							const delete_button = document.createElement("button");
							delete_button.innerText = "삭제";
							
							delete_button.addEventListener("click", function(){
								//alert("삭제되었습니다");
								let yn = confirm("삭제하시겠습니까?");
								//console.log(yn);
								if(yn){
									let comment_data = {num:data.num};
										
									$.ajax({
										url:"${pageContext.request.contextPath}/comment/delete",
										type:"DELETE",
										data:JSON.stringify(comment_data),
										contentType : "application/json; charset=utf-8",
										dataType : "html",
										success:function(data){
											div.remove();
										}
									});
								}
							});
								
							div.append(delete_button);
							
							// 수정 버튼
							// 수정 버튼
							const modify_button = document.createElement("button");
							modify_button.innerText = "수정";
							
							modify_button.addEventListener("click", function(){
								const edit_div = document.createElement("div");
								const edit_textarea = document.createElement("textarea");
								edit_textarea.cols = "200";
								edit_textarea.rows = "5";
								
								edit_textarea.value = p.innerText;
								
								const edit_modify = document.createElement("button");
								edit_modify.innerText = "수정완료";
								const edit_cancel = document.createElement("button");
								edit_cancel.innerText = "취소";
								
								edit_div.append(edit_textarea);
								edit_div.append(edit_modify);
								edit_div.append(edit_cancel);
								
								div.after(edit_div);
								div.style.display = "none";
								
								// 취소 버튼 클릭 시 이벤트
								edit_cancel.addEventListener("click", function(){
									div.style.display = "block";
									edit_div.remove();
								});
								
								// 수정완료 버튼 클릭 시 이벤트
								edit_modify.addEventListener("click", function(){
									//alert("수정완료 버튼 클릭");
									if(confirm("수정하시겠습니까")){
										let comment = edit_textarea.value;
										
										const modify_data = {comment, num:data.num};
										
										$.ajax({
											url:"${pageContext.request.contextPath}/comment/update",
											type:"PATCH",
											data:JSON.stringify(modify_data),
											contentType : "application/json; charset=utf-8",
											dataType : "json",
											success:function(data){
												console.log(data);
												p.innerText = data.comment;
												div.style.display = "block";
												edit_div.remove();
											}
										});
									}
								});
							});
							
							div.append(modify_button);
														
							div.prepend(p);
							div.prepend(h3);
														
							commentList.append(div);
						}
					});
				}else{
					alert("댓굴을 달아주세요");
				}
			});
		});
	</script>
</body>
</html>