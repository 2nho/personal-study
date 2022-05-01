package kr.co.goodee39.date1101;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex05While {
	// 반복문
	/* - Java에서는 동일한 로직을 조건에 따라 반복하기 위해 제공되는 문법이 있으며 이를 반복문이라 부른다.
	 * - Java에서 제공하는 반복문은 while문과 for문이 존재한다.
	 * while
	 * - while문은 조건식이 참인 동안에 해당 로직을 반복시키는 반복문이다.
	 * - while문은 로직 자체가 끝나는 리미터를 제공하지 않는 이상 초기값과 증감 연산을 이용해 제어를 해야한다.
	 * - while문은 초기값과 증감연산이 잘못 설정될 경우 무한 루프를 타기가 쉬워진다.
	 * for
	 * - for문은 while문의 단점을 보완하기 위해 초기값, 조건식, 증감연산이 같이 들어있는 반복문을 의미한다.
	 * - 초기값과 조건식 증감연산에 대한 위치를 고민할 필요가 없기 때문에 while보다 핸들링 하기 쉬워진다.
	 * - 리미트가 없는 반복을 수행할 경우 for문을 사용하는 경우가 많다.
	 * 
	 * ※ 조건문은 중첩이 가능하나 중첩시에는 로직을 파악하기 힘들어지므로 주의할 것
	 * */
	public static void main(String[] args) {
		int a = 0;
		while(a < 3) {
			System.out.println("현재 a 값 : "+a);
			a++;
		}
		
		System.out.println("-------------------------");
		
		for (int i = 0; i < 3; i++) {
			System.out.println("현재 i 값 : "+i);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Integer> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.println("iterator : "+iter.next());
		}
	}

}






