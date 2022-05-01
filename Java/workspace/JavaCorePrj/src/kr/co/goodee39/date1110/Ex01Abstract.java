package kr.co.goodee39.date1110;

public class Ex01Abstract {

	public static void main(String[] args) {
		AbstractChild ac = new AbstractChild();
		ac.method1();
		ac.method2();
		
		AbstractChild1 ac1 = new AbstractChild1();
		ac1.method1();
		ac1.method2();
		
		AbstractParent ap = new AbstractParent() {
			@Override
			public void method2() {
				System.out.println("아무것도 없음");
			}
		};
		
		ap.method1();
		ap.method2();
	}

}
