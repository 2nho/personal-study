package kr.co.goodee39.date1027;

public class Ex06Three {
	// 삼항연산자
	/* - 유일하게 논리값을 통해 선택적으록 값을 가져올 수 있는 연산자.
	 * - 삼항연산자는 조건식, 참일때의 값, 거짓일때의 값 세가지가 필요하다.
	 * - 조건식이 참일때는 참일때의 값이, 거짓일때는 거짓일때의 값이 필요하다.
	 * - 주의할 점은 참과 거짓의 타입이 동일하거나 다르더라도 자동 형변환이 가능해야 한다.
	 * - 삼항 연산자 안에 삼항 연산자를 넣어 사용할 수 있으며 이렇게 해서 다수의 조건 선택을 만족시키는 로직을
	 *   작성할 수 있다.
	 * 
	 * */
	public static void main(String[] args) {
		int a1 = 4;
		int a2 = (a1>2) ? 7 : 2;
		System.out.println(a2);
		
		int b1 = 5;
		int b2 = 6;
		int b3 = (b1 > 5)?10 :(b2>5)?11: 0;
		System.out.println(b3);
		
	}

}
