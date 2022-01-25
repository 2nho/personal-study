/**
 * 
 */

$(function(){
	let n1;
	let n2=0;
	let path = "";
	
	// GNB의 a태그 호버시 나타나는 이벤트
	$("#GNB a").hover(
		function(){
			n1 = $(this).parent().index();
			path = "images/nav"+(n1+1)+"_over.jpg";
			$(this).find("img").attr("src", path);	
		},
		function(){
			path = "images/nav"+(n1+1)+".jpg";
			$(this).find("img").attr("src", path);
		}
	);
	
	// 우측 하단 침대 4초 뒤에 계속 변하는 이벤트
	setInterval(function(){
		if(n2 < 3){
			n2++;
		}else{
			n2 = 0;
		}
		
		
		$(".gallery li").removeClass("active");
		$(".gallery li").eq(n2).addClass("active");
	}, 4000);
});


