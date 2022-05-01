package kr.co.goodee39.date1110;

public class Ex03Interface implements SampleInterface1{
	public int value1 = 5;
	
	public static void main(String[] args) {
		Ex03Interface ex = new Ex03Interface();
		ex.method1();
		ex.method2();
		
		System.out.println(SampleInterface1.VALUE_1);
		System.out.println(SampleInterface1.VALUE_2);
	}

	@Override
	public void method1() {
		System.out.println("method1 호출");		
	}

	@Override
	public void method2() {
		System.out.println("method2 호출");
	}

}
