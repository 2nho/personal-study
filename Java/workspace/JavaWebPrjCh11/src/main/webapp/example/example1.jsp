<%@page import="kr.co.goodee39.vo.SampleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int i = 3;
	String s = "안녕하세요";
	request.setAttribute("i", i);
	request.setAttribute("s", s);
	
	SampleVO vo = new SampleVO();
	vo.setNum(8);
	
	request.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%=request.getAttribute("i")%> </p>
	<P>${i+3}</P>
	<p>${s}</p>
	<p>${vo.num}</p>
	<p>${vo["num"]}</p>
</body>
</html>