package kr.co.goodee39.date1104;

public class Ex05Overload {
	// 오버로드
	/* - 메소드를 같은 이름으로 매개변수만 달리해서 여러개 선언하는 기능을 의미한다.
	 * - 자바에서 많이 쓰이기도 하는 문법 중 하나.
	 * - 메소드를 오버로드 하기 위해서는 반드시 매개변수의 수량과 타입이 달라야 한다.
	 * - 기능에 대한 매개변수를 분산하여 놓을 수 있는 장점이 있다.
	 * - 매개변수의 타입과 수량이 같지만 매개변수의 이름이 다르다고 해서 오버로드가 성립되진 않는다.
	 * */
	public void method1() {
		System.out.println("아무것도 없는 메소드 입니다.");
	}
	
//	public void method2() {
//		~~~~
//	}
	
	public void method1(String s1) {
		System.out.println("String 데이터는 : "+s1+"입니다.");
	}
	
	public void method1(String s2, String s3) {
		System.out.println("String s2 : "+s2);
		System.out.println("String s3 : "+s3);
	}
	
//	public void method1(String sss) {  // 에러 발생
//		System.out.println("sss : "+ sss);
//	}
	
	public static void main(String[] args) {
		Ex05Overload over = new Ex05Overload();
		over.method1();
	}

}
