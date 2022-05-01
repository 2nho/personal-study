package kr.co.goodee39.beans;

public class TestBean2 {
	public TestBean2() {
		System.out.println("TestBean2의 생성자");
	}
	
	public void defaultInit() {
		System.out.println("TestBean2의 default_init");
	}
	
	public void defaultDestroy() {
		System.out.println("TestBean2의 default_destroy");
	}
}
