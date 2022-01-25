package kr.co.goodee39.date1116;

public class Ex02Annoymous {
	
	public Ex02Annoymous() {
		System.out.println("반드시 한번의 로직");
	}
	
	public static void main(String[] args) {
		// new Ex02Annoymous();
		// 익명클래스
		/*
		 * - 실체가 없는 클래스를 즉석해서 만들어서 선언하는 방법
		 * - 인터페이스와 추상클래스는 자체적으로 인스턴스 선언을 할 수 없다.
		 * - 인스턴스 선언을 하기 위해서는 하위 클래스에서 구현이 되지 않은 메서드를 오버라이드 해서
		 *   구현을 한 다음 해당 클래스로 인스턴스를 선언하여야 정상적인 선언이 가능하다.
		 * - 하지만 해당 클래스 없이 추상클래스나 인터페이스 만으로 인스턴스를 선언할 수 있는데 이럴 때
		 *   반드시 인스턴스 선언 상에서 구현안된 메서드들을 반드시 구현해야 한다.
		 * - 이런식으로 실체가 존재하지 않는 클래스를 참조한다 하여 이를 이름이 없는 클래스, 익명클래스라고 한다.
		 */
		AbstractInner ai = new AbstractInner() {
			@Override
			public void method1() {
				System.out.println("method1 로직");
			}
		};
		
		ai.method1();
	}

}
