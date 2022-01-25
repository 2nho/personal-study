package kr.co.goodee39.date1027;

public class Ex03Compare {
	// 비교 연산자
	/* - 두개의 리터럴을 비교하는데 사용되는 연산자
	 * - 주로 반복문이나 조건문의 조건식에 사용된다.
	 * - 연산 결과는 무조건 논리형(true/false)가 된다.
	 * - 비교하는 피연산자의 자료형이 서로 다를 경우 자료형이 큰 쪽으로 형변환하여 피연산자의 타입을 일치시킨 후에 비교한다.
	 * - 등가 비교 연산자는 어떤 자료형이든 사용이 가능하지만 대소비교 연산자는 논리형과 참조형에서 사용이 불가능하다.
	 * 
	 * */
	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		
		System.out.println(a > b); // true
		System.out.println(a < b); // false
		System.out.println(a >= b); // true
		System.out.println(a <= b); // false
		System.out.println(a == b); // false;
		System.out.println(a != b); // true
		
		double c = 5.0;
		System.out.println(a == c); // true
		
		String d = "5";
//		System.out.println(a == d); // error
		
		char e = (char)5;
		System.out.println(a == e); // true
	}

}
