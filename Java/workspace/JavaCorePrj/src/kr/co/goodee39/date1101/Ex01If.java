package kr.co.goodee39.date1101;

public class Ex01If {
	// 조건문
	/* - 로직의 분기를 태울 경우 사용하는 문장
	 * - Java에서 사용되는 조건문으로 if와 switch-case 문장이 존재한다.
	 * - 로직의 분기를 통해 상황에 따라 다른 로직을 실행시키기 위해 사용하는 문장.
	 * If
	 * - 조건식에 따라서 다른 로직을 태울 경우 사용하는 문장
	 * - if문은 단순 if문, if~else문, 중첩if문, if~else if~else문이 존재한다.
	 * - if문은 조건에 따른 로직의 분기를 매우 다양하게 사용할 수 있어 많이 사용되는 로직 중 하나이다.
	 * */
	
	public static void main(String[] args) {
		int a = 5;
		if(a > 3) {
			System.out.println("a는 3보다 큽니다.");
		}
		System.out.println("무조건 실행되는 문장.");
		
//		if(a) {}  // 변수의 리터럴 값이 true 혹은 false가 될 수 없다.
		System.out.println("-------------------------------");
		
		if(a > 3) {
			System.out.println("a는 5보다 큽니다.");
		}else {
			System.out.println("a는 5보다 작습니다.");
		}
		
		if(a > 3) {
			if(a > 4) {
				System.out.println("a는 4보다 큽니다.");
			}
		}
		
		if(a < 4) {
			System.out.println("a는 4보다 작습니다");
		}else if(a < 5) {
			System.out.println("a는 5보다 작습니다");
		}else if(a < 6) {
			System.out.println("a는 6보다 작습니다");
		}else {
			System.out.println("a는 6보다 큽니다.");
		}
	}

}












