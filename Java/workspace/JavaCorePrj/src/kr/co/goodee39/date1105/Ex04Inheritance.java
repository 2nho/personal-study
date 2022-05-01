package kr.co.goodee39.date1105;

public class Ex04Inheritance {
	// 상속(inheritance)
	/* - 하나의 클래스에서 다른 클래스의 속성과 기능을 그대로 물려 받는것을 의미한다.
	 * - 보통 물려주는 쪽을 부모 클래스라 부르고 물려 받는 쪽을 자식 클래스라고 이야기한다.
	 * - 물려 주는 쪽의 기능과 속성을 자식클래스는 상속 받아 사용이 가능하며 이때 자식클래스는 부모클래스의
	 *   속성과 기능을 정의하지 않아도 된다.
	 * - 상속에서 연속적으로 클래스들이 상속을 할 경우 맨 마지막의 자식 클래스는 맨 상위의 부모 클래스부터의
	 *   모든 기능과 속성을 전부 사용할 수 있다.
	 * - 자바에서는 다중 상속이 지원되지 않는다.
	 * 
	 * */
	public static void main(String[] args) {
		
		ChildClass1 cc1 = new ChildClass1();
		cc1.putAccel();
		cc1.putBreak();
		System.out.println(cc1.color);
		System.out.println(cc1.fuel);
		
		ChildClass2 cc2 = new ChildClass2();
		System.out.println(cc2.field1);
		cc2.method1();
	}
}
