package kr.co.goodee39.date1116;

public class Ex03Rambda {
	// 람다식
	/*
	 * - 객체 지향 프로그래밍과 함수 지향 프로그래밍을 혼합하는 방법이 대세가 되면서 주목받기 시작.
	 * - 자바8 부터 람다식을 지원하기 시작
	 * - 자바 코드가 간결해지고 컬렉션의 요소를 필터링 하거나 매핑해서 원하는 결과를 집계할 수 있는 장점이 있다.
	 */
	public static void main(String[] args) {
//		RambdaInter1 rb = new RambdaInter1() {
//			@Override
//			public void method1() {
//				System.out.println("이것은 인터페이스 익명클래스");
//			}
//		};
//		rb.method1();
		
		// RambdaInter1 rb = () -> {System.out.println("이것은 인터페이스 익명클래스");};
		// 로직이 한줄이면 {} 생략 가능
		RambdaInter1 rb1 = () -> System.out.println("이것은 인터페이스 익명클래스");
		rb1.method1();
		
		// RambdaInter2 rb2 = (x) -> System.out.println("x 더하기 1은 : " + (x+1));
		// 매개변수가 하나일 경우 생략 가능
		RambdaInter2 rb2 = x -> System.out.println("x 더하기 1은 : " + (x+1));
		rb2.method1(3);
		
		RambdaInter3 rb3 = (x ,y) -> System.out.println("두 값의 합은 : "+(x+y));
		rb3.method1(3, 4);
		
		// RambdaInter4 rb4 = (a, b) -> {return a + b;};
		// 로직이 한줄이고 return이 있으면 {}와 return이 둘다 생략 가능
		RambdaInter4 rb4 = (a, b) -> a + b;
		System.out.println(rb4.method1(3, 4));
	}

}
