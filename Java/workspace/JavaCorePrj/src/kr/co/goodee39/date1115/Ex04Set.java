package kr.co.goodee39.date1115;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex04Set {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		
		set1.add("bbb");
		set1.add("aaa");
		set1.add("ddd");
		set1.add("eee");
		set1.add("ccc");
		
		System.out.println("bbb".hashCode());
		System.out.println("aaa".hashCode());
		System.out.println("ccc".hashCode());
		
		System.out.println(set1);
		
		System.out.println(set1.add("ccc"));
		
		System.out.println(set1);
		
		System.out.println("--------------------------------");
		
		Set<String> set2 = new TreeSet<String>();
		
		set2.add("bbb");
		set2.add("aaa");
		set2.add("ddd");
		set2.add("eee");
		set2.add("ccc");
		
		System.out.println(set2);
		
		System.out.println(set2.add("eee"));
		System.out.println(set2);
		
		System.out.println(set2.size());
		System.out.println(set2.remove("ddd"));
		System.out.println(set2);
		
		System.out.println(set2.size());
		
		for (String string : set2) {
			System.out.println(string);
		}

	}

}
