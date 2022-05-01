package kr.co.goodee39.date1109;

import kr.co.goodee39.date1109_1.ProtectedClass;
import kr.co.goodee39.date1109_1.PublicClass;

public class Ex15Contact extends ProtectedClass{
//	private String s1;
//	String s2;
//	protected String s3;
//	public String s4;
	
	public Ex15Contact() {
		// 프라이빗 클래스 영역
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);
//		
//		method1();
//		method2();
//		method3();
//		method4();
		
		// 디폴트 클래스 영역
//		DefaultClass dc = new DefaultClass();
		
		// System.out.println(dc.s1); // error
//		System.out.println(dc.s2);
//		System.out.println(dc.s3);
//		System.out.println(dc.s4);
		
		// dc.method1(); // error
//		dc.method2();
//		dc.method3();
//		dc.method4();
		
		// 프로텍티드 클래스 영역
//		System.out.println(super.s1); // error
//		System.out.println(super.s2); // error
//		System.out.println(super.s3);
//		System.out.println(super.s4);
		
//		super.method1(); // error
//		super.method2(); // error
//		super.method3();
//		super.method4();
		
		// 퍼블릭 클래스 영역
//		PublicClass pc = new PublicClass();
		
//		System.out.println(pc.s1); // error
//		System.out.println(pc.s2); // error
//		System.out.println(pc.s3); // error
//		System.out.println(pc.s4);
		
//		pc.method1(); // error
//		pc.method2(); // error
//		pc.method3(); // error
//		pc.method4();
	}
	
//	private void method1() {}
//	void method2() {}
//	protected void method3() {}
//	public void method4() {}
	
	
	public static void main(String[] args) {
		new Ex15Contact();
	}
}
