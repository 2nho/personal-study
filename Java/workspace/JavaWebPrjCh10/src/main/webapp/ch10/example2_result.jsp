<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.co.goodee39.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	List<EmpVO> list = (List<EmpVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
<%
	for(EmpVO vo : list){
%>
		<li><%=vo.getEmpno()%> : <%=vo.getEname()%> : <%=vo.getJob()%></li>
<%
	}
%>
	</ul>
</body>
</html>