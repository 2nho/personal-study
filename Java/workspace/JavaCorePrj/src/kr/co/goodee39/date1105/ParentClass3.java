package kr.co.goodee39.date1105;

public class ParentClass3 {
	int a1;
	String s1;
	
//	public ParentClass3() {
//		System.out.println("이것은 ParentClass3 입니다.");
//	}
	
	public ParentClass3(int a1, String s1) {
		this.a1 = a1;
		this.s1 = s1;
		System.out.println("이것은 ParentClass3의 두번째 생성자 입니다.");
	}
	
	public void method1() {
		System.out.println("method1 실행");
	}
	
	public void method2() {
		System.out.println("method2 실행");
	}
}
