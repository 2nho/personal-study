package kr.co.goodee39.date1027;

public class Ex04Logical {
	// 논리연산자
	/* - 논리 연산자는 논리형 값 과의 연산 결과를 출력하는 연산자. 
	 * - 연산의 결과값은 논리형으로 나온다.
	 * - 논리 연산자는 &&(AND), ||(OR), !(NOT) 세가지가 있다.
	 * - && : 두 개의 값이 모두 참이면 참 아니면 거짓
	 * - || : 두 개의 값이 하나라도 참이면 참 아니면 거짓
	 * - ! : 참을 거짓으로 거짓을 참으로 바꿔줌
	 * - &&연산자의 전위 결과가 false일 때 후위 연산을 하지 않음
	 * - ||연산자의 전위 결과가 true일 때 후위 연산을 하지 않음
	 * */
	public static void main(String[] args) {
		boolean a1 = true;
		boolean a2 = true;
		boolean b1 = true;
		boolean b2 = false;
		boolean c1 = false;
		boolean c2 = false;
		
		System.out.println(a1 && a2); // true;
		System.out.println(b1 && b2); // false;
		System.out.println(c1 && c2); // false;
		
		System.out.println(a1 || a2); // true;
		System.out.println(b1 || b2); // true;
		System.out.println(c1 || c2); // false;
		
		int d1 = 3;
		int d2 = 4;
		
		System.out.println((3>5) && ((++d1) > 1));
		System.out.println(d1); // 3
		
		System.out.println((5>3)|| ((++d2)>2));
		System.out.println(d2); // 4
		
		System.out.println(!true);
		System.out.println(!false);
	}

}
