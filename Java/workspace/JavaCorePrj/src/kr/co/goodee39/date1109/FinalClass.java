package kr.co.goodee39.date1109;

// 상속 불가능
//public final class FinalClass {
public class FinalClass {
	// 상수화
	public static final int ABC = 123;
	// 오버라이드 불가
	public final void method1() {
		System.out.println("method1 메소드 영역");
	}
}
