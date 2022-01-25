package kr.co.goodee39.date1103;

public class Ex04Class {

	public static void main(String[] args) {
		// 클래스
		/* - 객체를 생성하기 위한 틀
		 * - 클리스를 활용하여 인스턴스(객체)를 생성할 수 있다.
		 * - 클래스는 객체 그 자체가 아니며 단순히 객체를 생성하기 위한 틀에 불과하다.
		 * - 클래스에서는 실제 속성을 나타내는 맴버변수(필드)와 동작을 나타내는 메서드로 구성을 나눌 수 있다.
		 * - 클래스는 해당 클래스를 감싸고 있는 파일과 이름이 동일해야 하며 1파일 = 1클래스로 구성되는 것을 원칙으로 한다.
		 * 
		 * */
		
		// 객체 선언 방법
		/* - 객체선언타입 인스턴트명(변수명) = new 생성자함수(); 
		 * 
		 * */
		
		// JVM(Java Virtual Machine)
		/* - JVM은 자바의 파일이 컴파일 되어 런타임 영역에서 실행이 되어질 때 어플리케이션이 실행하기 위한 환경을
		 *   컴퓨터 내에서 구성해주는 역할을 한다.
		 * - 실행되는 어플리케이션에서 메모리를 관리하기 위해 5개의 메모리 영역으로 나누어 관리를 한다.
		 * - 메모리는 클래스영역(메소드영역, 스태틱영역), 힙영역, 콜스택영역, 네이티브 메소드, PC 레지스터 영역으로 나뉜다.
		 * - 주 메모리는 클래스 영역, 힙 영역, 콜 스택 영역으로 나뉘게 된다.
		 * */
		
		// JAVA 객체의 선언과 JVM의 동작
		/* - 자바 어플리케이션에서 인스턴스(객체)를 선언하게 되면 JVM에서는 클래스 영역에서 해당 클래스의 정보를 바탕으로
		 *   힙에서 공간을 생성하여 해당 인스턴스의 속성과 메소드의 기본 정보를 띄운다.
		 * - 인스턴스 변수는 힙 영역에 존재하는 미리 세팅되어진 인스턴스의 정보를 가리키게 된다.
		 * - 해당 인스턴스의 필드 값들은 전부 힙 영역에 저장되며 메소드의 경우 실제 동작하는 로직은 콜 스택 영역에서
		 *   이루어진다.
		 * - 메소드는 단순히 힙에서 콜스택 영역을 가리키는 주소만 가지고 있다.(실제 힙에서 동작하고 실행되어지는 것은 아님)
		 * 
		 * */
		Car car1 = new Car();
		System.out.println(car1.color);
		System.out.println(car1.fuel);
		car1.putAccel();
		car1.putBreak();
		car1.color = "검은색";
		car1.fuel = 100;
		
		System.out.println("----------------------");
		System.out.println(car1.color);
		System.out.println(car1.fuel);
		
		System.out.println("======================");
		Car car2 = new Car();
		System.out.println(car2.color);
		System.out.println(car2.fuel);
		
		System.out.println("======================");
		Car car3 = car2;
		car3.color ="흰색";
		car3.fuel = 50;
		
		System.out.println(car3.color);
		System.out.println(car3.fuel);
		
		System.out.println(car2.color);
		System.out.println(car2.fuel);
		
		System.out.println("======================");
		System.out.println(car1);
	}

}









