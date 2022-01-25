<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String headerMenu1 = "Home";
String headerMenu2 = "로그인";
String headerMenu3 = "회원가입";
String headerMenu4 = "내정보";
String headerMenu5 = "장바구니";
String headerMenu6 = "주문/배송조회";
String headerMenu7 = "오시는길";
String headerMenu8 = "사이트맵";

String searchOption1 = "전체";
String searchOption2 = "숯 / 황토";
String searchOption3 = "은사";
String searchOption4 = "피그먼트";
String searchOption5 = "속솜";

String banner1Word1 = "10:00 ~ 19:00";
String banner1Word2 = "일요일, 공휴일 휴무";
String banner1Word3 = "TEL. 031-914-1500";
String banner1Word4 = "fine211@kornet.net";

String banner2Word1 = "예금주/***";
String banner2Word2 = "485-000000-00000";

String itemName1 = "천연염색은사";
String itemPrice1 = "289,000원";

String itemName2 = "천연염색차렵이";
String itemPrice2 = "199,000원";

String itemName3 = "피그먼트차렵이";
String itemPrice3 = "149,000원";

String itemName4 = "메모리폼";
String itemPrice4 = "29,000원";

String notion1 = "카드 결제 등록이 완료되었습니다.";
String notion2 = "저희 쇼핑몰의 모든 상품은 백화점 판매 제품과 동일합니다.";
String notion3 = "5월 중 백화점 판매일정 - 롯데 백화점 관악점, 영등포점 ...";

String copyRightMain = "COPYRIGHT 2005 SKY TOWN ALL RIGHT RESERVED.";

String copyRightMenu1 = "이용안내";
String copyRightMenu2 = "이용약관";
String copyRightMenu3 = "개인보호정책";

String footer1 = "(주)파인21 대표 이병하｜사업자등록번호 128-81-90833｜경기도 파주시 교하읍 아당리 488";
String footer2 = "본사전화 031-957-1510｜팩스 031-957-1509｜통신판매업 신고번호 파주-345호｜개인정보 관리책임자 이창욱";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div class="wrapper">
		<header id="header">
			<div class="upper">
				<ul>
					<li><a href=""><%=headerMenu1%></a></li>
					<li><a href=""><%=headerMenu2%></a></li>
					<li><a href=""><%=headerMenu3%></a></li>
					<li><a href=""><%=headerMenu4%></a></li>
					<li><a href=""><%=headerMenu5%></a></li>
					<li><a href=""><%=headerMenu6%></a></li>
					<li><a href=""><%=headerMenu7%></a></li>
					<li><a href=""><%=headerMenu8%></a></li>
				</ul>
			</div>
			<div class="search_zone">
				<div class="logo">
					<h1>
						<a href=""><img src="images/logo.gif" alt="" /></a>
					</h1>
				</div>
				<div class="search">
					<form action="">
						<label for="search"><img src="images/label_search.gif"
							alt="" /></label> <select name="" id="search">
							<option value=""><%=searchOption1%></option>
							<option value=""><%=searchOption2%></option>
							<option value=""><%=searchOption3%></option>
							<option value=""><%=searchOption4%></option>
							<option value=""><%=searchOption5%></option>
						</select> <input type="text" id="area" /> <input type="image"
							src="images/btn_search.gif" alt="" />
					</form>
				</div>
			</div>
			<div class="menu">
				<nav id="GNB">
					<ul>
						<li><a href=""><img src="images/nav1.jpg" alt="" /></a></li>
						<li><a href=""><img src="images/nav2.jpg" alt="" /></a></li>
						<li><a href=""><img src="images/nav3.jpg" alt="" /></a></li>
						<li><a href=""><img src="images/nav4.jpg" alt="" /></a></li>
					</ul>
				</nav>
			</div>
		</header>
		<section id="contents">
			<div class="customer_zone">
				<div class="banner1">
					<img src="images/banner1.jpg" alt="고객상담" /> <span> <%=banner1Word1%><br />
						<%=banner1Word2%><br /> <%=banner1Word3%><br /> 
						<a href="mailto:<%=banner1Word4%>"><%=banner1Word4%></a></span>
				</div>
				<div class="banner2">
					<img src="images/banner2.jpg" alt="무통장입금" />
					<span>
					<%=banner2Word1%><br />
					<%=banner2Word2%>
					</span>
				</div>
				<div class="banner3">
					<img src="images/banner3.jpg" alt="매장안내" />
				</div>
			</div>
			<div class="shop_zone">
				<h3>
					<img src="images/title_shop.gif" alt="" />
				</h3>
				<div class="sky_town">
					<img src="images/banner_sky_town.jpg" alt="" />
				</div>
				<div class="fabric">
					<img src="images/banner_fabric.jpg" alt="" />
				</div>
			</div>
			<div class="news_zone">
				<div class="product">
					<div class="tit">
						<a href="" class="more"><img src="images/btn_more1.gif" alt="" /></a>
						<span>New Product</span>
					</div>
					<ul>
						<li><a href=""> <img src="images/photo_product1.jpg"
								alt="" /> <span><%=itemName1%><br><%=itemPrice1%></span></a></li>
						<li><a href=""><img src="images/photo_product2.jpg"
								alt="" /><span><%=itemName2%><br><%=itemPrice2%></span></a></li>
						<li><a href=""><img src="images/photo_product3.jpg"
								alt="" /><span><%=itemName3%><br><%=itemPrice3%></span></a></li>
						<li><a href=""><img src="images/photo_product4.jpg"
								alt="" /><span><%=itemName4%><br><%=itemPrice4%></span></a></li>
					</ul>
				</div>
				<div class="notice">
					<div class="tit"><a href="" class="more"><img src="images/btn_more2.gif" alt="" /></a>
						<span>Notice</span>
					</div>
					<div class="table">
						<table>
							<caption>Notice</caption>
							<tbody>
								<tr>
									<td><a href=""><%=notion1%></a></td>
								</tr>
								<tr>
									<td><a href=""><%=notion2%></a></td>
								</tr>
								<tr>
									<td><a href=""><%=notion3%></a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="gallery">
					<ul>
						<li class="active"><img src="images/gallery1.jpg" alt="" /></li>
						<li><img src="images/gallery2.jpg" alt="" /></li>
						<li><img src="images/gallery3.jpg" alt="" /></li>
						<li><img src="images/gallery4.jpg" alt="" /></li>
					</ul>
				</div>
			</div>
		</section>
		<div class="copyright">
			<div class="footer_logo"><img src="images/bottom_logo.gif" alt="" /></div>
			<div class="list">
				<div class="right"><%=copyRightMain%></div>
				<ul>
					<li><a href=""><%=copyRightMenu1%></a></li>
					<li><a href=""><%=copyRightMenu2%></a></li>
					<li><a href=""><%=copyRightMenu3%></a></li>
				</ul>
			</div>
		</div>
		<footer id="footer">
			<div class="footer_sign"><img src="images/bottom_sign.gif" alt="" /></div>
			<div class="list">
				<%=footer1 %><br><%=footer2 %>
			</div>
		</footer>
	</div>
</body>
</html>





