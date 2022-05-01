package kr.co.goodee39.date1112;

public class Ex02Enum {
	
	public String name;
	public int size;
	public Shoes shoes1;
	public Shoes shoes2;
	
	public static void main(String[] args) {
		// Enum
		/* - 사용자가 임의로 선언한 상수들의 집합
		 * - 기존의 상수를 정의하는 방법이었던 static final과 같이 문자열이나 숫자들을 나타내는 기본자료형의 값을
		 *   enum을 이용해서 같은 효과를 낼 수 있다.
		 * - Enum을 사용하게 되면 코드가 단순해지며 가독성이 좋아지고, 상수 타입에 대한 안정성이 생기면서, 복잡한
		 *   로직을 단순하게 처리할 수 있도록 만들어준다.
		 * - 데이터를 가독성 있게 만들어 줌으로써 로직을 상당히 개선시킨다는 점에서 많은 사람들이 이용하는 기능.
		 */
		Ex02Enum enumShoes = new Ex02Enum();
		
		enumShoes.name = "나이키";
		enumShoes.size = 250;
		enumShoes.shoes1 = Shoes.RUNNING;
		enumShoes.shoes2 = Shoes.RUNNING;
		
		System.out.println("신발 브랜드 : "+enumShoes.name);
		System.out.println("신발 사이즈 : "+enumShoes.size);
		System.out.println("신발 종류 : "+enumShoes.shoes1);
		System.out.println(enumShoes.shoes1 == enumShoes.shoes2);
		
		System.out.println(enumShoes.shoes1.getName());
		enumShoes.shoes2.printName();
		
		System.out.println("-------------------------------------");
		// 열거 객체의 문자열을 리턴
		System.out.println(enumShoes.shoes2.name());
		// 열거 객체의 순번을 리턴
		System.out.println(enumShoes.shoes2.ordinal());
		// 열거 객체를 비교해서 순번 차이를 리턴
		enumShoes.shoes2 = Shoes.HIKING;
		System.out.println(enumShoes.shoes1.compareTo(enumShoes.shoes2));
		// 모든 열거 객체들을 배열로 리턴
		Shoes[] shooooose = Shoes.values();
		for (Shoes shoes : shooooose) {
			System.out.println(shoes);
		}
	}

}






