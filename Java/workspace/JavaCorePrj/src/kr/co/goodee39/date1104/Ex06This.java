package kr.co.goodee39.date1104;

public class Ex06This {
	// this
	/* - 객체 나 자신을 가리킬 때 쓰는 예약어
	 * - 같은 객체 내에서 존재하는 필드나 메서드를 사용할 경우 쓰는 키워드
	 * - 클래스 내의 메서드에서 해당 클래스에 존재하는 다른 메서드 혹은 필드에 접근할 경우 this. 을 활용해서 접근이 가능하다.
	 * - 단 클래스 내의 메서드에서 해당 필드나 메서드를 접근하기 위해 this. 은 생략이 가능하다.
	 * - this. 를 쓸 경우 강제제적으로 내 클래스 안의 필드 혹은 메서드를 가리키는 효과가 있으므로 외부에서 받아온 매개변수의 이름이
	 *   필드의 이름이 같을 시 효과적으로 사용이 가능하다.
	 * - 생성자를 접근할 경우 this(생성자에서 선언한 매개변수) 를 활용하여 접근할 수 있다.
	 * - 단 생성자에 접근할 경우 생성자 내에서만 접근이 가능하며 생성자는 다른 필드나 메서드의 접근 또한 가능하지만, 일반 메서드에서
	 *   생성자의 접근은 불가능하다. 
	 * */
	
	
	int a;
	String b;
	
	public Ex06This() {
		this(3, "cdf");
	}
	
	public Ex06This(int a, String b) {
		this.a = a;
		this.b = b;
	}
	
	public void method1() {
//		this.a = 10;
//		this.b = "abc";
//		this.method2();
		
		a = 10;
		b = "abc";
		method2();
	}
	
	public void method2() {
		System.out.println("int a : "+a);
		System.out.println("String b : "+b);
	}
	
	public void method3(int a, String b) {
		this.a = a;
		this.b = b;
	}
	
	public void method4() {
//		this();  // 에러
	}
	
	public static void main(String[] args) {
		Ex06This ex = new Ex06This();
		ex.method2();
		System.out.println("==========================");
		ex.method1();
	}

}
