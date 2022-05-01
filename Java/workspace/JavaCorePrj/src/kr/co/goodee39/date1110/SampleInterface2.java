package kr.co.goodee39.date1110;

public interface SampleInterface2 {
	// default 메서드
	default void method1() {
		System.out.println("method1 호출");
	}
	
	// static 메서드
	public static void method2() {
		System.out.println("method2 호출");
	}
}
