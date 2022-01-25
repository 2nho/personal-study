package kr.co.goodee39.date1115;

import java.util.ArrayList;
import java.util.List;

public class Ex01ArrayList {

	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list.toString());
		
		System.out.println(list.get(2));
		
		list.set(3, 10);
		
		System.out.println(list);
		
		list.remove(1);
		
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
