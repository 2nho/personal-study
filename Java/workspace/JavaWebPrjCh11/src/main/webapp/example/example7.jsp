<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:forTokens var="현재 아이템의 변수명"
					items="반복할 대상이 있는 아이템"
					delims="구분자(여러개 지정 가능)"
					begin="시작 값, 기본값은 0"
					end="종료 값"
					step="증가값"
					varStatus="반복 상태 값을 지닌 변수"/>
	 --%>
	 <c:forTokens var="color" items="빨|주|노|초|파|남|보" delims="|" varStatus="i">
	 	<c:if test="${i.first}">color : </c:if>
	 	${color}
	 </c:forTokens>
</body>
</html>