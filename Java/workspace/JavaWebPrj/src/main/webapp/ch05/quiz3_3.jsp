<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String value = request.getParameter("value");
	
	String img = "";
	String name = "";
	String desc = "";
	
	if(value.equals("1")){
		img="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/sample85.jpg";
		name="Pudol Doux";
		desc="All this mordern technology just makes people try to everything at once.";
	}else if(value.equals("2")){
		img="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/sample96.jpg";
		name="Kurie Secco";
		desc="If you do the job badly enough sometimes you don't get asked to do it again";
	}else {
		img="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/sample92.jpg";
		name="Zosaisan Invec";
		desc="If your knees aren't green by the end of the day. you ought to seriously re-exammine your life.";
	}
%>

<jsp:forward page="quiz3_4.jsp">
	<jsp:param value="<%=img %>" name="img"/>
	<jsp:param value="<%=name %>" name="name"/>
	<jsp:param value="<%=desc %>" name="desc"/>
</jsp:forward>