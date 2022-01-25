package kr.co.goodee39.date1102;

public class Ex04NonObject {

	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		outputSum(a, b);
	}
	
	// 스태틱 메소드
	public static void outputSum(int x, int y) {
		System.out.println(x+y);
	}
}
