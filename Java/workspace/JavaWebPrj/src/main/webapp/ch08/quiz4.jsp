<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Mailing List</h2>
	<form action="<%=request.getContextPath()%>/Quiz41Controller">
		<label for="email"></label>
		<input type="email" id="email" name="email" size=25/>
		<button type="submit">전송</button>
		<button type="reset">리셋</button>
	</form>
	<p></p>
	<h2>Login</h2>
	<form action="<%=request.getContextPath()%>/Quiz42Controller">
		<label for="id">ID :</label>
		<input type="text" name="id" size="10" id="id"/>
		<label for="pw">PW : </label>
		<input type="password" name="pw" id="pw" size="10"/>
		<button>login</button>
	</form>
	<p></p>
	<h2>여름방학 특강 신청하기</h2>
	<form action="<%=request.getContextPath()%>/Quiz43Controller">
		<fieldset>
			<legend>교육과정</legend>
			<label for="time">영어회화</label>
			<input type="text" id="time" name="time" size="15" placeholder="오전 9:00~11:00" />(초급레벨)
		</fieldset>
		<fieldset>
			<legend>신청자 기본정보</legend>
			<ul>
				<li><label for="name">이름</label><input type="text" id="name" name="name" size="15" /></li>
				<li><label for="email">이메일</label><input type="email" name="email" id="email" size="15" /></li>
				<li><label for="password">패스워드</label><input type="password" name="password" id="password" size="15" /></li>
				<li><label for="major">학과</label><select name="major" id="major">
					<option value="">학과를 선택하세요</option>
					<option value="mechanic">기계공학과</option>
					<option value="indust">건축공학과</option>
					<option value="computer">컴퓨터공학과</option>
				</select></li>
				<li>
					<label for="">성별</label>
					<input type="radio" name="gender" id="man" value="m" />
					<label for="man">남자</label>
					<input type="radio" name="gender" id="woman" value="w" />
					<label for="woman">여자</label>
				</li>
				<li>
					<label for="">관심사</label>
					<input type="checkbox" name="favor" id="" value="travel"/>여행
					<input type="checkbox" name="favor" id=""  value="game"/>게임
					<input type="checkbox" name="favor" id="" value="show"/>공연
					<input type="checkbox" name="favor" id="" value="exercize"/>운동
					<input type="checkbox" name="favor" id="" value="etc"/>기타
				</li>
			</ul>
		</fieldset>
		<button type="submit">수강신청</button><button type="reset">다시쓰기</button>
	</form>	
	
</body>
</html>





