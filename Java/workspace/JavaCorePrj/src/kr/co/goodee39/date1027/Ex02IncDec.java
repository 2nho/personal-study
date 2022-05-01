package kr.co.goodee39.date1027;

public class Ex02IncDec {
	//증감연산자
	/* - 변수의 값을 1 증가 혹은 감소시킬 때 쓰는 연산자.
	 * - 연산이 전위냐 후위냐에 따라서 연산 순서가 달라진다.
	 *   => 전위 : 연산이 먼저 수행되고 해당 라인의 로직이 나중에 실행
	 *   => 후위 : 연산이 나중에 수행되고 해당 라인의 로직이 먼저 실행
	 * 
	 * */
	public static void main(String[] args) {
		int i = 3;
		System.out.println(++i); // 4;
		System.out.println(--i); // 3;
		
		System.out.println(i--); // 3;
		System.out.println(i++); // 2;
	}
}
