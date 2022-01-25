<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// 선언부 : 클래스, 변수등을 선언하는 곳
class ExampleA{
	private String str;
	
	public void setStr(String str){
		this.str = str;
	}
	
	public String getStr(){
		return str;
	}
}

int a = 1;
String b = "abc";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 스크립트릿 : 자바 로직을 생성하는 곳
// 페이지와의 자바를 통한 동기화를 하고자 할 경우 쓰이는 곳
	ExampleA exa = new ExampleA();
	exa.setStr("abcd");
%>

<%-- 익스프레션 : 선언부, 혹은 스크립트릿에서 작성한 로직들을 html상으로 표현하는 문구 --%>
	<p>get ext : <%=exa.getStr()%></p>
	<p>String b : <%=b %></p>
</body>
</html>









