package kr.co.goodee39.date1026;

public class Ex10VariableSurvive {
	// 변수의 생존 범위
	/* - java 변수는 위치에 다라 생존할 수 있는 범위가 있다.
	 * - {}를 기준으로 변수의 생존 범위가 결정된다.
	 * - 변수의 생존 범위는 변수가 생성된 곳 부터 해당 영역이 끝날 때 까지가 된다.
	 * - 변수가 생존하고 있는 동안에만 접근이 가능하며 변수가 생존하지 않는 다른 영역에서는 생존이 불가능하다
	 * - 밖의 {}에서 선언된 변수는 안의 {}에서 접근이 가능하지만, 안의 {}에서 선언된 변수는 밖에서 접근이 불가능하다.
	 * */
	public static void main(String[] args) {
		int a = 1;
		{
			int b = 2;
			{
				int c = 3;
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
			}
			System.out.println(a);
			System.out.println(b);
			//System.out.println(c); // 에러
		}
		System.out.println(a);
//		System.out.println(b); // 에러
//		System.out.println(c); // 에러

	}

}
