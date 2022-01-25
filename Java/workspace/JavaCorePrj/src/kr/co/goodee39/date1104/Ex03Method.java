package kr.co.goodee39.date1104;

public class Ex03Method {
	// 메소드
	/* - 메소드는 실제 클래스에서 기능을 정의하는 역할을 수행한다.
	 * - 메소드의 형식은 접근제한자, 리턴타입, 메서드명(매개변수...) 순으로 정의가 가능하다.
	 * - 메소드는 리턴타입과 매개변수에 따라 성질이 바뀌게 된다.
	 * - 리턴타입이 없을 때는 메서드 명 앞에 void를 놓게 되며 안쪽에 반환하고자 하는 로직 구현을 하지 않아도 된다.
	 * - 하지만 리턴타입을 명시할 경우 메소드명 앞에 void 대신 리턴할 타입을 선언하고 반드시 로직 안에 return이 존재해야 한다.
	 * - 매개변수는 아무것도 선언하지 않아도 되며 선언할 경우 하나 이상의 매개변수 선언이 가능하다.
	 * - 매개변수 선언 시 반드시 [변수 타입][변수 명] 식으로 선언을 해야 한다.
	 * - 만약 내가 몇개의 데이터를 받을 지 알 수 없을 때에는 매개변수의 변수 명 앞에 ... 을 붙여 동적으로 데이터를 받을 수 있다.
	 *   => 단 이럴 경우 동적으로 받는 데이터들의 타입이 동일해야 하며 이를 안지킬 경우 에러가 난다. 
	 * 
	 * */
	
	// 접근제한자 리턴타입 메솨드명(매개변수..){ 로직 }
	public void method1() {
		System.out.println("method1 메소드 호출!");
	}
	
	// 매개변수가 있는 메소드
	public void method2(int a, String b) {
		System.out.println("int a : " +a);
		System.out.println("String b : "+b);
	}
	
	// 매개변수를 동적으로 여러개 받는 메소드
	public void method3(int ...a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i+"회차 : " + a[i]);
		}
	}
	
	// 리턴타입이 있는 메소드
	public String method4() {
		return "method4를 활용한 String 타입 리턴";
	}
	
	// 리턴 타입은 오로지 하나만 작성 가능하다.
//	public int,String method5(){
//		return 1,"abc"
//	}
	
	// 리턴타입과 매개변수를 둘다 가지고 있는 메서드
	public int method6(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		Ex03Method method = new Ex03Method();
		method.method1();
		method.method2(123, "abc");
		method.method3(1,2,3,4,5,6,7);
		System.out.println(method.method4());
		System.out.println("1더하기 2는? : "+method.method6(1, 2));
	}

}
