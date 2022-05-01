package kr.co.goodee39.date1104;

public class Ex04Constructor {
	// 생성자 (Constructor)
	/* - 생성자는 맨 처음 인스턴스가 실행되기 전 실행되는 메서드를 의미한다.
	 * - 클래스 초기화 할때 쓰이는 메소드
	 * - 생성자는 접근제한자 클래스명(매개변수 ) 형태로 정해진 모양이 있다.
	 * - 생성자를 생성하지 않았을 경우 JVM에서 디폴트 생성자를 먼저 생성해주고 마치 생성자가 있는 것 처럼 동작한다.
	 * - 그러나 생성자를 하나라도 생성할 경우 디폴트 생성자는 소멸된다.
	 * - 생성자에서는 메소드나 필드에 자유롭게 접근이 가능하다. 
	 * */
	String str1;
	String str2;
	
	public Ex04Constructor() {
		System.out.println("이것은 Ex04의 생성자 입니다!!");
	}
	
	public Ex04Constructor(String s1, String s2) {
		str1 = s1;
		str2 = s2;
		method1();
	}
	
	public void outputField() {
		System.out.println("str1 : "+str1);
		System.out.println("str2 : "+str2);
	}
	
	public void method1() {
		System.out.println("여기는 method1 입니다.");
	}
	
	public static void main(String[] args) {
//		Ex04Constructor cons = new Ex04Constructor();
		Ex04Constructor cons = new Ex04Constructor("안녕하세요","반갑습니다");
		cons.outputField();
	}

}
