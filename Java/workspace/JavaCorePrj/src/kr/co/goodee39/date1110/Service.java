package kr.co.goodee39.date1110;

public class Service {
	@PrintAnnotation
	public void method1() {
		System.out.println("안녕하세요");
	}
	@PrintAnnotation("/")
	public void method2() {
		System.out.println("반갑습니다");
	}
	@PrintAnnotation(value="#", number=20)
	public void method3() {
		System.out.println("hello java");
	}
}
