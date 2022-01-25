package kr.co.goodee39.date1113;

public class Ex04JavaExample {
	// 필드(맴버변수) : 기본형 참조형 다 선언 가능함
	//     => 필드값이 초기화가 안되었을 경우 디폴트로 초기화가 된다.
	//   int : 0
	//   double : 0.0
	//   char : 0x0000
	//   boolean : false
	//   Obj : null;
	int a = 1;
	String s = "abc";
	// 생성자
	// - 객체를 생성할 때 최초로 실행되는 메서드
	// - 선언하지 않았을 때 default 생성자를 쓴다.
	// - 명시적으로 생성자를 선언할 경우 default 생성자는 소멸됨
	// - 초기화의 역할을 수행한다.
	public Ex04JavaExample(int a, String s) {
		this.a = a;
		this.s = s;
	}
	// this
	// - 내 안에 있는 자원에 접근할 경우 붙이는 접두어
	// - 생략 가능
	// - 생성자 호출 시 this(); 로 호출 가능 
	// - 생성자 this는 생략이 불가능하다.
	// - 생성자 안에서는 생성자를 호출할 수 있고, 일반 메서드 또한 호출이 가능하다.
	// - 일반 메서드에서 생성자 호출은 불가능
	
	// 메서드 : 매개변수, 리턴타입을 정해줄 수 있다.
	public void method1() {
		this.s = "bbc";
		System.out.println("method1 메소드");
	}
	
	public String method2() {
		System.out.println("method2 메소드");
		return "abcd";
	}
	
	public void method3(int a, int b) {
		System.out.println(a+b);
	}
	
	public String method4(String s) {
		return s+"입니다";
	}
	
	public static void main(String[] args) {
		Ex04JavaExample ex1= new Ex04JavaExample(1, "abc");
		System.out.println(ex1.a);
		System.out.println(ex1.s);
		ex1.method1();
		ex1.method2();
		
		Ex04JavaExample ex2 = new Ex04JavaExample(1, "abc");
		ex2.a = 100;
		System.out.println(ex2.a);
		System.out.println(ex1.a);
		
		Ex04JavaExample ex3 = ex1;
		ex3.a = 10;
		System.out.println(ex3.a);
		System.out.println(ex1.a);
	}
}
