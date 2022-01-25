package kr.co.goodee39.date1113;

public class Ex02JavaExample {
	public static void main(String[] args) {
		// 연산자
		// 산술 연산자 : + , - , * , / , %
		System.out.println(1+2);
		System.out.println(3-1);
		System.out.println(2*4);
		System.out.println(8/2);
		System.out.println(4%2);
		byte a1 = 2;
		byte a2 = 3;
		byte a3 = (byte)(a1 + a2);
		float f1 = 1.3f;
		float f2 = 2.2f;
		float f3 = f1 + f2;
		// 증감 연산자
		int b1 = 3;
		System.out.println(++b1);  // b = b + 1  연산을 먼저 수행
		System.out.println(b1++);  // b = b + 1  연산을 나중에 수행
		int b2 = 4;
		System.out.println(--b2);  // b = b - 1  연산을 먼저 수행
		System.out.println(b2--);  // b = b - 1  연산을 나중에 수행
		// 비교 연산자  // 결과는 무조건 불리언
		System.out.println(5>3);
		System.out.println(5<3);
		System.out.println(5>=3);
		System.out.println(5<=3);
		System.out.println(5==3);
		System.out.println(5!=3);
		// 논리 연산자
		// && : 양 변이 true 면 true, 아니면 false
		System.out.println((3>2)&&(5>2));  // ~이고 ~이면
		// || : 양 변중 하나라도 true면 true, 아니면 false
		System.out.println((3>2)||(5>2));  // ~이거나 ~이면
		// ! : true=>false, false=>true
		System.out.println(!true);
		System.out.println(!false);		
		// 주의사항 : && 연산자에서 좌변이 false일 경우 우변에 있는 식은 연산되지 않는다.
		//          || 연산자에서 좌변이 true일 경우 우변에 있는 식은 연산되지 않는다.
		// 대입 연산자
		// a = a + 1 => a += 1
		// 삼항 연산자 : 결과에 따라 다른 값을 반환하는 연산자. 
		// - 형식 : (비교식)?참일때의 값 : 거짓일때의 값
		// - 주의할 점 : 값의 자료형은 같아야 한다.
		// ※ 삼항 연산자 안에 삼항연산자 선언이 가능
		int c1 = (5>3)?5 : 3;
		
		// 제어문
		// 조건문
		// - if(단순조건)
		if(5<3) {
			System.out.println("이거 실행");
		}
		// - if~else
		if(5>3) {
			System.out.println("5가 3보다 크다");
		}else {
			System.out.println("5가 3보다 작다");
		}
		// - 중첩 if 문 : if문 안에 if문을 넣을 수 있다. 너무 남발하지 말 것
		// - if ~ else if ~ else : 범위가 작은 곳에서 큰 곳으로 조건을 수행할 경우 쓰기 용이하다.
		int c2 = 8;
		if(c2 < 5) {
			System.out.println("5보다 작습니다.");
		}else if(c2 < 9) {
			System.out.println("9보다 작습니다.");
		}else {
			
		}
		
		// - switch~case : 변수에 들어있는 값과 값의 동등 비교를 통한 참 거짓을 판단하고 참일 경우 로직을 수행
		int c3 = 2;
		switch(c3) {
		case 1:
			System.out.println("c3 : 1");
			break;
		case 2:
			System.out.println("c3 : 2");
			break;
		case 3:
			System.out.println("c3 : 3");
			break;
		case 4:
			System.out.println("c3 : 4");
			break;
		default :
			System.out.println("c3 : ?");
		}
		// 반복문
		// - while
		int d1 = 0;
//		while(d1 < 5) {
//			System.out.println(d1);
//			d1++;
//		}
		do {
			System.out.println(d1);
			d1++;
		}while(d1 < 5);
		// break; continue;
		do {
			d1++;
			System.out.println(d1);
			// break; continue;
		}while(d1 < 5);
		
		
		// - for
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		
		// 이중 for 문
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
			}
		}
	}
}










