<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*, *:before, *:after {
	box-sizing : border-box;
}

body {
	font-family : san-serif;
	color : #384047;
}

form {
	max-width : 300px;
	margin : 10px auto;
	padding : 10px 20px;
	background : #f4f7f8;
	border-radius : 8px;
}

h1 {
	margin : 0 0 30px 0;
	text-align : center;
}

input[type="text"], input[type="password"], input[type="email"], textarea, select {
	background: rgba(255,255,255, 0.1);
	border : none;
	font-size : 1rem;
	height : auto;
	margin : 0;
	padding : 15px;
	width : 100%;
	background-color : #e8eeef;
	color : #8a97a0;
	box-shadow : 0 1px 0 rgba(0, 0, 0, 0.3) inset;
	margin-bottom : 30px;
}

input[type="radio"], input[type="checkbox"] {
	margin : 0 4px 8px 0;	
}

select {
	padding : 6px;
	height : 32px;
	border-radius : 2px;
}

button {
	padding : 19px 39px 18px 39px;
	color : white;
	background-color : #4bc970;
	font-size : 18px;
	text-align : center;
	border-radius : 5px;
	width : 100%;
	border: 1px solid #3ac162;
	border-width : 1px 1px 3px;
	margin-bottom : 10px;
}

fieldset {
	margin-bottom : 30px;
	border : none;
}

legend {
	font-size : 1.4rem;
	margin-bottom : 10px;
}

label {
	display : block;
	margin-bottom : 8px;
}

label.light{
	font-weight : 300;
	display : inline;
}

.number {
	background-color : #5fcf80;
	color : white;
	height : 30px;
	width : 30px;
	display : inline-block;
	font-size : 0.8rem;
	margin-right : 4px;
	line-height : 30px;
	text-align : center;
	text-shadow : 0 1px 0 rgba(255, 255, 255, 0.2);
	border-radius : 100%;
}
</style>
</head>
<body>
	<div class="row">
		<div>
			<form action="<%=request.getContextPath()%>/Quiz2Controller" method="post">
				<h1>회원가입</h1>
				<fieldset>
					<legend><span class="number">1</span>기본정보</legend>
					<label for="name">이름 : </label><input type="text" id="name" name="user_name" />
					<label for="email">Email : </label><input type="email" id="email" name="user_email" />
					<label for="password">비밀번호 : </label><input type="password" id="password" name="user_password" />
					<label>나이 : </label>
					<input type="radio" name="user_age" id="under_13" value="under_13"/>
					<label for="under_13" class="light">13살 이하</label>
					<input type="radio" name="user_age" id="over_13" value="over_13"/>
					<label for="over_13" class="light">13살 이상</label>
				</fieldset>
				<fieldset>
					<legend><span class="number">2</span>추가 정보</legend>
					<label for="intro">자기소개 : </label><textarea name="user_intro" id="intro" cols="30" rows="10"></textarea>
					<label for="job">주요직업 : </label>
					<select name="user_job" id="job">
						<optgroup label="web">
							<option value="frontend_developer">프론트앤드 개발자</option>
							<option value="spring_developer">스프링 개발자</option>
							<option value="devops_developer">데브옵스 개발자</option>
							<option value="web_disigner">웹 디자이너</option>
							<option value="php_developer">PHP 개발자</option>
						</optgroup>
					</select>
					<label>관심 분야 : </label>
					<input type="checkbox" name="user_interest" id="development" value="interest_development" /><label for="development" class="light">Development</label>
					<input type="checkbox" name="user_interest" id="design" value="interest_design" /><label for="design" class="light">Design</label>
					<input type="checkbox" name="user_interest" id="business" value="interest_business" /><label for="business" class="light">Business</label>
				</fieldset>
				<button>가입하기</button>
			</form>
		</div>
	</div>
</body>
</html>