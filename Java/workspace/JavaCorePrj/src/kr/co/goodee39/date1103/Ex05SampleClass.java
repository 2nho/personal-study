package kr.co.goodee39.date1103;

public class Ex05SampleClass {
	
	int a = 3;
	String str="abc";
	
	public void methodA() {
		System.out.println("methodA 메서드 호출 입니다.");
	}
	
	public void methodB() {
		System.out.println("methodB 메서드 호출 입니다.");
	}
	
	public static void main(String[] args) {
		Ex05SampleClass sc = new Ex05SampleClass();
		sc.methodA();
		sc.methodB();
	}

}
