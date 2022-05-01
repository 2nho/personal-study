package kr.co.goodee39.date1105;

public class ChildClass4 extends ParentClass4{
	@Override
	public void method1() {
		System.out.println("이것은 자식클래스에서 실행한 method1 입니다.");
	}
	
	public void method2() {
		super.method1();
	}
}
