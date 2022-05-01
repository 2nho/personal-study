package kr.co.goodee39.ver0;

public class Boy implements Person{
	public void doSomething() {
		System.out.println("문을 열고 집에 들어간다.");
		try {
			System.out.println("컴퓨터로 게임을 한다.");
			System.out.println("잠을 잔다");
		} catch (Exception e) {
			System.out.println("119에 신고한다.");
		} finally {
			System.out.println("문을 열고 집을 나온다.");
		}

	}
}
