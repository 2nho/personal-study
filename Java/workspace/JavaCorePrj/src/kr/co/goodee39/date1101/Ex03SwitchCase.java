package kr.co.goodee39.date1101;

public class Ex03SwitchCase {
	// switch~case
	/* - 기존의 if~else if~else문을 대체할 수 있는 조건문
	 * - switch~case문은 동등 비교만 가능하며 switch 문에 변수, 혹은 값만이 사용이 가능하다.
	 * - 비교문을 통한 결과에 따라 분기를 할 수 없으니 주의할 것
	 * - switch~case문 의 case 안쪽에는 break를 넣음으로써 로직에 대한 잘못된 처리를 방지할 수 있다.
	 * - break문을 넣지 않을 경우 아래있는 로직까지 전부 실행되며 break문을 만나기 전까지 switch 문을
	 *   벗어나지 않는다.
	 * - 반드시 모든 case문 안에 break문을 삽입하여야 하며 이를 역이용해서 범위 색인형태의 조건을 입힐수도
	 *   있다.
	 * 
	 * */
	public static void main(String[] args) {
		
		int a = 2;
		
//		switch(a) {
//		case 1:
//			System.out.println("a는 1입니다");
//			break;
//		case 2:
//			System.out.println("a는 2입니다");
//			break;
//		case 3:
//			System.out.println("a는 3입니다");
//			break;
//		default :
//			System.out.println("해당되는 a값이 없습니다.");
//		}
		
		switch(a) {
		case 1:
		case 2:
		case 3:
			System.out.println("a는 1부터 3 사이의 숫자입니다.");
			break;
		default :
			System.out.println("해당되는 a값이 없습니다.");
		}
	}

}
