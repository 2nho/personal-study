package kr.co.goodee39.date1116;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class Ex04Consumer {
	// 표준 API 함수 인터페이스
	/*
	 * - 자바에서 제공되는 표준 API에서 한 개의 추상 메소드를 가지는 인터페이스들은 모두 람다식을 이용해서 
	 *   익명 구현 객체로 표현이 가능하다.
	 * - 자바 8부터 빈번하게 사용되는 함수적 인터페이스는 java.util.function에 표준 API 패키지로 제공한다.
	 * - java.util.function  패키지의 함수적 인터페이스는 크게 Consumer, supplier, Function,
	 *   Operator, Predicate로 구분된다.
	 */
	
	// Consumer
	/*
	 * - 리턴값이 없는 accept() 메소드를 가지고 있다.
	 * - 매개변수의 타입과 수에 따라서 각기 다양한 Consumer를 제공한다.
	 */
	public static void main(String[] args) {
		Consumer<String> c1 = t -> System.out.println(t + "8");
		c1.accept("java");
		
		BiConsumer<Integer, Integer> c2 = (x, y) -> System.out.println(x+y);
		c2.accept(2, 3);
		
		DoubleConsumer c3 = d -> System.out.println(d);
		c3.accept(3.2);
		
		ObjIntConsumer<String> c4 = (s, i) -> System.out.println(s+i);
		c4.accept("Spring", 5);
	}

}
