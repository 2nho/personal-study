<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// pageContext
		/*
			- 자신의 페이지 내에서만 생존
			- 다음 페이지로 이동 시 해당 객체는 소멸되고 새로운 객체가 생성됨
		*/
		String str1 = "안녕하세요";
		pageContext.setAttribute("str1", str1);
		
		// Request
		/*
			- 다음 요청 전 까지 생존
			- 다음 요청이 발생하게 되면 Request 는 소멸되고 새로운 Request가 생성
		*/
		// Redirect/forward
		/*
			- Redirect : 서버에 요청 정보를 전송하게 되면 원하는 페이지를 바로 전달해 주는것이 아닌
						 서버에서 해당 페이지에 대한 정보를 웹으로 재 반환한다. 클라이언트는 그 정보를
						 활용해 다시 서버에 정보를 요청하여 페이지를 받아온다.
			- forward : 서버에 요청 정보를 전송하게 되면 서버 내부에서 내가 원하는 페이지를 찾아
						해당 페이지에 대한 정보를 보여준다. 요청을 두번이 아닌 한번만 보내는게 특징
		*/
		// Request 생존범위와 Redirect/Forward
		/*
			- request 객체는 다음 요청 전까지만 생존하므로 Redirect를 통해 전송하게 되면 이전 request 객체는
			  자연스럽게 소멸되기 때문에 정상적인 데이터 전송이 불가능하다.
			- 반면 forward로 요청이 들어갈 경우 요청이 한번밖에 일어나지 않으므로 request 객체는 생존이 가능하며
			  이를 통해 데이터에 대한 전송이 가능해진다.
		*/
		String str2 = "반갑습니다";
		request.setAttribute("str2", str2);
		
		// Session
		/*
			- 클라이언트와 서버의 연결이 끊기기 전까지 생존
			- 세션이 한번 연결이 되는것은 클라이언트와 서버가 연결이 되는 순간 최초 한번이 연결이 되고 그 뒤로 유지가 된다.
			- 세션이 연결될 시에 서버에서는 클라이언트에게 JSESSIONID라는 쿠키 값을 전송해주고 클라이언트의 개별적인
			  정보를 담을 수 있도록 공간을 할당한다.
			- 클라이언트가 서버에 요청을 하게되면 서버는 JSESSIONID를 통해 사용자의 개인적인 데이터를 색인해
			  사용이 가능하도록 한다.
			- 이러한 특징때문에 로그인 후의 사용자의 권한, 혹은 중요한 정보의 관리를 맡고 있다.
		*/
		String str3 = "이것은 세션입니다";
		session.setAttribute("str3", str3);
		
		// Application
		/*
			- 서버가 생존해 있는 동안 계속 생존해 있는 객체
			- 이 객체는 다른 클라이언트에서도 정보를 공유 및 사용이 가능하다.
			- 공통적으로 사용자들이 사용하는 정보일 경우 Appliaction에 저장해서 사용할 수 있다.
			- 만약 서버가 꺼지게 되면 Application에 들어있는 데이터는 자동 소멸하게 된다.
			- 주의할 점은 Application에 많은 데이터를 집어넣게 되면 서버에 부하가 갈 수 있으므로 주의 할 것.
		*/
		String str4 = "이것은 어플리케이션입니다.";
		application.setAttribute("str4", str4);
	%>
	<jsp:forward page="./Example4_1.jsp"></jsp:forward>
	<%
		// response.sendRedirect(request.getContextPath()+"/ex01/Example4_1.jsp");
	%>
</body>
</html>







