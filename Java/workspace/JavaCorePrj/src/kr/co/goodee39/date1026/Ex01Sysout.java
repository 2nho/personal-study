package kr.co.goodee39.date1026;

public class Ex01Sysout {

	public static void main(String[] args) {
		// println : 한줄 개행하여 출력할 경우 사용
		System.out.println("안녕하세요");
		System.out.println("반갑습니다");
		System.out.println(12345);
		System.out.println('김');
		System.out.println(true);
		// print : 출력을 하지만 개행을 하지 않는다.
		//         개행을 하기 위해서는 \n을 이용해서 개행을 해야 한다.
		System.out.print("안녕하세요\n");
		System.out.print("반갑습니다");
		System.out.print(12345);
		System.out.print('김');
		System.out.print(true);
		// printf : 출력을 하지만 개행이 되지 않는다.
		//          지시자를 사용한다.
		/* 지시자란?
		 * - 외부에 있는 변수 혹은 값을 출력하고자 할 경우 어떤 타입의 값을 어디에 출력할 것인지를 정할 때 지시자를
		 *   사용할 수 있다.
		 * - 지시자를 사용함으로써 좀 더 데이터에 대한 다양한 표현이 가능해진다.
		 * - 지시자를 이용하지 않고 결합 연산자를 사용하여 변수를 출력할 수 도 있다.
		 * 
		 * 지시자의 종류
		 * - %b : 논리형
		 * - %d : 10진수
		 * - %o : 8진수
		 * - %x : 16진수
		 * - %f : 실수형 10진수
		 * - %e : 지수 표현
		 * - %c : 문자 하나
		 * - %s : 문자열
		 * */
		System.out.println();
		int a = 300;
		System.out.println("============================================");
		System.out.printf("제가 출력한 값은 %d 입니다. 또 %d를 입력했습니다\n", 100, 200);
		System.out.println("제가 출력한 값은 "+100+" 입니다. 또 "+200+"를 입력했습니다");
		System.out.printf("변수에 들어있는 값은 %d 입니다\n", a);
		System.out.println("변수에 들어있는 값은 "+a+" 입니다");
	}

}
