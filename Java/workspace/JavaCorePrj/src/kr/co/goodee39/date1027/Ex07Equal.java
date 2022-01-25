package kr.co.goodee39.date1027;

public class Ex07Equal {
	// 대입 연산자
	/* - 연산을 한 결과값을 다시 해당 변수에 대입할 경우 사용하는 연산자.
	 * - = 앞에 연산하고자 하는 기호를 붙여 연산을 하도록 하는 연산자이다.
	 * - 자바에서 또한 이를 간략하게 하여 대입연산자를 사용하는 것을 권자앟고 있다.
	 * */
	public static void main(String[] args) {
		int a = 1;
//		a = a + 2;
		a += 2;
		System.out.println(a); // 3
		
		int b = 2;
		b -= 1;
		System.out.println(b); // 1
		
		int c = 3;
		c *= 3;
		System.out.println(c); // 9
		
		int d = 8;
		d /= 2;
		System.out.println(d); // 4
		
		int e = 16;
		e %=7;
		System.out.println(e); // 2
	}

}
