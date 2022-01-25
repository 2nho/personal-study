package kr.co.goodee39.date1027;

public class Ex05Bit {

	public static void main(String[] args) {
		// 비트연산자
		/* - 비트연산자는 데이터를 비트화 하여 연산할 때 쓴다.
		 * - 빈도가 많지 않으나 고속 연산을 할 경우 사용할 수 있다.
		 * */
		byte a = 10; // 00001010
		byte b = 9; //  00001001
		byte c = 1;
		
		System.out.println(a&b); // 00001000 // 10
		System.out.println(a|b); // 00001011 // 11
		System.out.println(a^b); // 00000011 // 3
		System.out.println(~10); // ~00001010 => 11110101
		System.out.println(a << c); // 00010100 // 20
		System.out.println(a >> c); // 00000101 // 5
		System.out.println(a >>> c); // 5
		System.out.println(-10 >> c); // -5      11111111 >> 2 => 11111111   -10 >> 2  11110110 >> 2 => 11111101
		System.out.println(-10 >>> c); // 2147483643    11111111 >> 2 => 00111111   11110110 >>> 2 => 00111101
		
	}

}
