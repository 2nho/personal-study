package kr.co.goodee39.beans;

public class TestBean3 {
	public TestBean3() {
		System.out.println("TestBean3의 생성자 입니다.");
	}
	
	public void bean3Init() {
		System.out.println("TestBean3의 init 메서드");
	}
	
	public void bean3Destroy() {
		System.out.println("TestBean3의 destroy 메서드");
	}
	
	public void defaultInit() {
		System.out.println("TestBean3의 default_init");
	}
	
	public void defaultDestroy() {
		System.out.println("TestBean3의 default_destroy");
	}
}
