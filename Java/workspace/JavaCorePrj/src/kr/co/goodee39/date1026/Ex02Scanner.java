package kr.co.goodee39.date1026;

import java.util.Scanner;

public class Ex02Scanner {
	
	public static void main(String[] args) {
		/* Scanner
		 * - 콘솔창에서 출력하는 것 외에 입력하는 기능을 가진 내장 클래스
		 * - 실제 입력받는 것은 System.in 이지만 조정해야 할 부분이 많고 쓰기가 어렵다는 단점이 있다.
		 * - 이런 단점을 극복하기 위해 만들어진 기능이 Scanner이며 이것을 통해 좀 더 쉬운 입력이 가능하다.
		 * 
		 * Scanner에서 제공하는 메서드
		 * - nextLine() : 문자열을 입력받을 때 사용
		 * - next() : 공백이 없는 단어 하나를 입력받을 때 사용
		 * - nextInt() : 정수를 입력받을 때 사용
		 * - nextDouble() : 실수를 입력받을 때 사용
		 * - nextBoolean() : 논리값을 입력받을 때 사용
		 * */		
		Scanner s = new Scanner(System.in);
		
//		System.out.println("내가 입력한 값은 : "+s.nextInt());
//		System.out.println("내가 입력한 값은 : "+s.next());
		System.out.println("내가 입력한 값은 : "+s.nextLine());
		
		// Scanner의 메모리를 반환하는 메소드
		s.close();
	}

}
