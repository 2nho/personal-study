package kr.co.goodee39.date1105;

public class Ex03Wrapper {
	// wrapper class
	/* - 기존의 개본형 변수는 자체적으로 제공하는 기능이 없으며 오로지 값을 담거나 값을 호출할 때 쓰게 된다.
	 * - 이러한 기능적인 한계를 극복하기 위해 나온것이 wrapper클래스이다.
	 * - wrapper 클래스는 해당 타입에 필요한 기능들을 열거하고 타입에 대한 변환 및 참조형처럼 쓰고자 만들어졌다.
	 * - wrapper 클래스는 추가적인 기능을 사용하거나 Generic 타입을 지정할 때 쓸 수는 있지만. 남용하게 되면
	 *   그만큼의 오버헤드가 증가하기 때문에 특별히 기능을 사용하거나 Generic 타입으로 사용할 것이 아니라면
	 *   기본형 변수를 쓰는것이 좋다.
	 * */
//	int a = 3;
//	float b = 4.2f;
	Byte a = 6;
	Short b = 7;
	Integer c = 3;
	Long d = 12L;
	Float e = 1.2f;
	Double f = 2.3;
	Character g = 'a';
	Boolean h = true;
	String s = "안녕하세요";
	
	Integer c2 = c;
	
	public static void main(String[] args) {
		Ex03Wrapper ex = new Ex03Wrapper();
		System.out.println(ex.a);
		System.out.println(ex.a.doubleValue());
		System.out.println(ex.a.doubleValue());
		
		ex.c2 = 22;
		System.out.println(ex.c);
	}

}
