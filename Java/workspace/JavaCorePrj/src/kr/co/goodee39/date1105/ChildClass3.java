package kr.co.goodee39.date1105;

public class ChildClass3 extends ParentClass3{
	int a2;
	String s2;
	
	public ChildClass3() {
//		super();
		super(1, "abc");
	}
	
	public void method3() {
		System.out.println("method3 실행");
		super.method1();
//		this.method1();
	}
	
	public void method4() {
		System.out.println("method4 실행");
	}
}
