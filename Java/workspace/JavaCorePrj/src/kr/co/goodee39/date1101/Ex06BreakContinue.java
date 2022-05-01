package kr.co.goodee39.date1101;

public class Ex06BreakContinue {
	// break, continue
	/* break
	 * - 반복문에서 아래 로직을 중지하고 반복문을 빠져나갈 때 쓰는 문장
	 * - 무한루프가 걸릴 것 같은 상황에 내부에서 조건을 주어 break문을 실행하게 되면 로직을 안전하게 수행할 수 있다.
	 * continue
	 * - 반복문에서 특정 루프를 생략할 때 쓰는 문장
	 * - 루프의 특정 조건에 해당하는 로직을 실행시키지 않고 다시 재 루프를 돌릴 시 사용한다.
	 * */
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			if(i == 3) continue;
			System.out.println("i의 현재 값 : "+i);
		}
		
		System.out.println("--------------------------------");
		
		for (int i = 0; i < 5; i++) {
			if(i == 3) break;
			System.out.println("i의 현재 값 : "+i);
		}
		
		System.out.println("--------------------------------");
		
		int a = 0;
		do {
			System.out.println(a);
			a++;
		}while(a< 3);
	}

}
