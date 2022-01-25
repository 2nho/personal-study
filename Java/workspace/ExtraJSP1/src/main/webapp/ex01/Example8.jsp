<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str1 = "100";
	String str2 = "200";
	String str3 = "300";
	String str4 = "400";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 액션 include
	/*
		- 액션 include는 메인 페이지를 가져와서 먼저 클라이언트에서 읽고 include의 요청이 있을 시
		  그때마다 서버에 해당 페이지를 요청하여 가져오는 형태로 페이지를 읽어들이는 방식을 의미한다.
		- 메인 페이지와 서브페이지와의 데이터 동기화가 안되기 때문에 데이터를 메인페이지에서 지정해야 하는
		  번거로운 단점이 존재한다.
		- 하지만 페이지의 스테이츠에 따라서 내가 다른 페이지를 보여줄 수가 있으며 또한 페이지가 오작동이
		  생길 경우에 대한 페이지 대처를 할 수 있다는 장점이 존재한다.
	
	*/
	
	// 디렉티브 include
	/*
		- 디렉티브 include는 액션 include하고는 달리 서버에서 모든 페이지를 조립해서 나오는 성질을 지닌다.
		- 메인 페이지에서 선언한 데이터가 서브 페이지에 전부 동기화가 된다는 점이 장점이며 데이터를 일일히
		  따로 선언하여 request를 통해 가져오지 않아도 된다는 장점이 존재한다.
		- 단 각각의 페이지마다 데이터의 동기화 시 에러가 발생할 경우 전체 페이지가 전부 뜨지 않는 단점이 존재하며
		  각각의 원자 페이지에 대한 에러의 정합성을 검사해주어야 한다는 단점이 존재한다.
	*/
	
	/*
		- 두개의 방식 즉 디렉티브 include 방식과 액션 include 방식은 동작하는 방식에서 차이가 발생하는데
		  상황에 따라 맞게 두개중 하나를 골라 사용하면 된다.
		- 다만 디렉티브 include 방식의 경우 페이지 호출 시 데이터 동기화가 안되는 괴정에서 발생하는 자잘한 에러가
		  존재하며 이클립스에서는 해당 에러를 잡아내지 못하는 상황이 종종 발생하므로 이점을 유의해야 한다.
	*/
%>
	<%@ include file="./Example8_header.jsp"%>
	<hr />
	<h1>여기는 Example8 본문입니다.</h1>
	<hr />
	<%@ include file="./Example8_footer.jsp"%>
</body>
</html>










