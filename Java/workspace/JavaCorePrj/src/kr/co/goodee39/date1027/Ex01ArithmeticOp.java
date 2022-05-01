package kr.co.goodee39.date1027;

public class Ex01ArithmeticOp {
	// 산술연산자
	/* - 산술 연산은 더하기, 빼기, 곱하기, 나누기, 나머지 다섯개의 연산을 의미한다.
	 * - 곱샘, 나눗셈, 나머지 연산이 덧셈, 뺄셈 연산보다 연산 우선순위가 높다.
	 * - 산술 연산시 int보다 크기가 작은 자료형은 int형으로 형변환 뒤에 연산을 한다.
	 * - int형 보다 클 경우 소수 우선으로 소수에 맞춰서 형이 변화된다.
	 * - 해당 연산자의 볌위를 초과한 숫자를 넣을 경우 예상한 결과와 다르게 나올 수 있다.
	 * */
	public static void main(String[] args) {
		int a1 = 3;
		int a2 = 8;
		System.out.println(a1+a2);
		System.out.println(a1-a2);
		System.out.println(a1*a2);
		System.out.println((a2/(double)a1));
		System.out.println(a2%a1);
		
		byte b1 = 2;
		byte b2 = 3;
		byte b3 = (byte)(b1 + b2); // int + int => int
		int b4 = b1 + b2;
		
		float f1 = 2.34f;
		int f2 = 3;
		float f3 = f1+f2;
		
		float f4 = 3.14f;
		long f5 = 5;
		float f6=f4 + f5;
		
		long l1 = 12;
		double l2 = 54.23;
		double l3 = l1+l2;
		System.out.println(l3);
		
		int x = 1000000;
		int y = 2000000;
		System.out.println(x*y);
		
	}

}
