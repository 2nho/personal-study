package kr.co.goodee39.date1116;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex15Exception {
	// 예외처리
	/* - 프로그래머가 코드를 작성중에 일어나는 오타 혹은 로직적인 오류를 보통 오류라고 부른다.
	 * - 하지만 외부의 입력 혹은 외부의 데이터를 가져오는 과정에서 혹은 관련 연산에서 나오는 오류를
	 *   예외라고 부른다.
	 * - 예외처리는 프로그래머가 낸 에러는 아니지만 반드시 처리해줘야만 한다.
	 * - 이런 처리를 하기 위해 자바에서 특수한 문장을 제공하는데 이를 예외처리라고 한다.
	 * - 자바에서의 예외처리는 두가지가 존재하는데 하나는 try~catch를 통해 처리하는 방법이고 또 하나는
	 *   throw를 통해 상위로 던지는 방법이 있다.
	 */
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			BigInteger a = scan.nextBigInteger();
			System.out.println(a);
		} catch(InputMismatchException e) {
			System.out.println("예외가 발생했습니다.");
			e.printStackTrace();
		}
	}

}
