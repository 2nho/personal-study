<%@page import="kr.co.goodee39.vo.AirVO"%>
<%@page import="kr.co.goodee39.vo.ShipVO"%>
<%@page import="kr.co.goodee39.vo.CarVO"%>
<%@page import="kr.co.goodee39.vo.BasicVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	BasicVO vo = null;
	String type = (String)request.getAttribute("type");
	if(type.equals("1")){
		vo = (CarVO)request.getAttribute("vo");
	}else if(type.equals("2")){
		vo = (ShipVO)request.getAttribute("vo");
	}else if(type.equals("3")){
		vo = (AirVO)request.getAttribute("vo");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%=vo.getId() %></p>
	<p><%=vo.getKind() %></p>
	<p><%=vo.getAmount() %></p>
	<p><%=vo.getOrigin() %></p>
	<p><%=vo.getDes() %></p>
	<%if(type.equals("1")){%>
	<p><%=((CarVO)vo).getCarnum() %></p>
	<p><%=((CarVO)vo).getDriver() %></p>
	<p><%=((CarVO)vo).getPhone() %></p>
	<% }else if(type.equals("2")){%>
	<p><%=((ShipVO)vo).getShipnum() %></p>
	<p><%=((ShipVO)vo).getPort() %></p>
	<% }else if(type.equals("3")){%>
	<p><%=((AirVO)vo).getStartair() %></p>
	<p><%=((AirVO)vo).getDesair() %></p>
	<%}%>
</body>
</html>