package kr.co.goodee39.date1112;

public class Ex04GenericExtends {
	// 제네릭
	/* - 기존 일반 오브젝트 타입은 타입을 명시하기 위해 반드시 캐스팅 연산자를 붙여야만 쓸 수 있었다.
	 * - Java1.5 이후에 위와 같은 문제점을 해결하기 위해 제네릭 타입이 추가 됨.
	 * - 제네릭 타입은 잘못된 타입이 사용될 소 있는 문제를 컴파일 과정에서 소거가 가능하도록 해줌.
	 * - 제네릭은 클래스와 인터페이스, 메소드, 필드를 정의할 때 사용할 수 있다.
	 * - 타입 체킹 및 타입 변환을 막을 때 사용한다.
	 * - 제네릭 타입은 하나 이상 사용이 가능하다.
	 * - 제네릭 타입은 클래스 메소드에서 선언해 사용이 가능하다.
	 * - 제네릭 타입은 extends를 통해 실제 사용하는 제네릭 타입의 범위를 지정할 수 있다.
	 * - 제네릭 타입이 선언된 클래스를 상속 받을 때 제네릭 타입을 상속받는 자식 객체는 제네릭 타입을 더 선언할 수 있다.
	 * - 이때 자식 클래스는 부모 클래스에서 선언한 제네릭 타입을 전부 앞에 선언해주어야 하며 자식의 제네릭 타입 갯수는
	 *   부모보다 작을 수 없다.
	 */
	
	public static void main(String[] args) {
		ChildProduct1<String, Integer, String> child1 = new ChildProduct1<String, Integer, String>();
		child1.setT("제네릭 T 타입");
		child1.setM(1234);
		child1.setC("자식 제네릭 M 타입");
		
		System.out.println(child1.getT());
		System.out.println(child1.getM());
		System.out.println(child1.getC());
	}

}
