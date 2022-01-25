package kr.co.goodee39.date1117;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ex05Stream {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaaaa");
		list.add("bbbbb");
		list.add("ccccc");
		list.add("ddddd");
		list.add("eeeee");
		
//		for (String string : list) {
//			System.out.println(string);
//		}
		
		Stream<String> stream = list.stream();
		stream.forEach(s -> System.out.println(s));
		
		System.out.println("------------------------");
		
		Stream<String> pstream = list.parallelStream();
		pstream.forEach(s -> System.out.println(s));
	}

}
