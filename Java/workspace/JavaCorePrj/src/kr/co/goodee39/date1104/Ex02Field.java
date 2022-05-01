package kr.co.goodee39.date1104;

public class Ex02Field {
	
	// field
	/* - 클래스 내에서 선언되어지는 변수를 이야기함
	 * - 보통 맴버변수라고 이야기를 하기도 함
	 * - 클래스 내부에서 선언이 되어지며 모든 클래스 내의 메소드에서 접근해서 사용이 가능하다.
	 * - field 값을 초기화 하지 않을 경우 해당 타입에 따라 다르게 초기화가 자동으로 이루어지는데
	 *   각 타입마다 자동화 되는 값은 다음과 같다.
	 *   => int = 0;
	 *   => float, double = 0.0;
	 *   => char = 0x0000(NUL);
	 *   => boolean = false;
	 *   => String or Object = null;
	 * ※ 모든 참조형 변수는 예외없이 null로 초기화 된다.
	 * */
	
	
	int a; // 0
	float b; // 0.0
	double c; // 0.0
	char d; // 0x0000
	boolean e; // false
	String f; // null
	
	public void init() {
		System.out.println("int : "+a);
		System.out.println("float : "+b);
		System.out.println("double : "+c);
		System.out.println("char : "+(int)d);
		System.out.println("boolean : "+e);
		System.out.println("String : "+f);
	}
	
	public static void main(String[] args) {
		Ex02Field field = new Ex02Field();
		field.init();
	}

}
