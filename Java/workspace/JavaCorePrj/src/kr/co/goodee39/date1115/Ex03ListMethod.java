package kr.co.goodee39.date1115;

import java.util.LinkedList;
import java.util.Stack;

public class Ex03ListMethod {
	// List
	/* - 연속적인 데이터를 담고자 하는 자료구조 공간
	 * - 각 데이터는 배열처럼 인덱스라는 주소값을 가지고 접근이 가능하다.
	 * - 데이터를 추가할 때나 삭제될 때 List의 크기가 유동적으로 늘어났다 줄어든다.
	 * - List를 통해 데이터의 추가/삭제가 일어날 경우 기존 데이터들이 빈 공간을 메꿔 중간에 데이터의 구멍이 생기는것을 방지한다.
	 * - 모든 리스트를 순차적으로 색인할 경우 사용하는 대표적인 콜렉션 중 하나
	 * - 종류로는 ArrayList, LinkedList, Stack 등이 있다.
	 * 
	 * */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		
		System.out.println("----------------------------");
		
		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("aaa");
		ll.add("bbb");
		ll.add("ccc");
		ll.add("ddd");
		ll.add("eee");
		
		System.out.println(ll);
		
		ll.addFirst("zzz");
		
		System.out.println(ll);
	}

}
