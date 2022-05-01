package kr.co.goodee39.date1112;

public class Ex01InstanceOf {
	// 다형성
	/* - 하나의 객체 타입으로 여러가지 객체를 참조할 수 있는 성질을 의미
	 * - 조상 타입을 상속받은 하위 객체들은 실제 조상의 타입으로 자신의 객체로 인스턴스 생성이 가능하다.
	 * - 이렇게 되면 하나의 변수로 여러가지 참조 값을 변수에서 가져갈 수 있으며 상당히 여러 용도로 사용이 가능하다.
	 * - 이후 GoF에서 만든 디자인 패턴의 보급과 함께 현재 중요해지고 있는 이론중에 하나이다.
	 * */
	public static void main(String[] args) {
		TVProduct tv = new TVProduct();
		
		if(tv instanceof TV) {
			System.out.println("이 객체는 TV를 상속받은 객체입니다.");
		}
	}

}
