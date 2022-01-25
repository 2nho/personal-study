package kr.co.goodee39.date1105;

public class Ex06Override {
	// 오버라이드
	/* - 자식 클래스에서 부모클래스에 정의되어 있던 기능을 같은 이름의 기능으로 선언해서 덮어 씌우는 것을 뜻함
	 * - 메모리에서는 실제 해당 기능을 검색 시 자식 쪽에서 해당 기능의 호출을 가로채서 부모까지 기능에 대한 검색을
	 *   막는 형태의 매커니즘을 가짐
	 * - 만약 강제로 부모 클래스의 기능을 접근하고 싶다면 super을 활용하여 부모 객체의 기능에 접근이 가능함.
	 * 
	 * */
	public static void main(String[] args) {
		ChildClass4 cc1 = new ChildClass4();
		cc1.method1();
		cc1.method2();
	}

}
