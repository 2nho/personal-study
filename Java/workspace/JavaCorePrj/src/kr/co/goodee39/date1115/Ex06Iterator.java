package kr.co.goodee39.date1115;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex06Iterator {

	public static void main(String[] args) {
//		Set<Student> set = new HashSet<Student>();
//		
//		set.add(new Student("마동석",10));
//		set.add(new Student("김종국",20));
//		set.add(new Student("이정제",48));
//		set.add(new Student("이순재",50));
//		set.add(new Student("이나영",30));
//		
//		java.util.Iterator<Student> iterator = set.iterator();
//		
//		while(iterator.hasNext()) {
//			Student std = iterator.next();
//			System.out.println("이름 : "+std.getName());
//			System.out.println("나이 : "+std.getAge());
//			System.out.println("----------------------------");
//		}
		
		List<Student> list = new ArrayList<Student>();

		list.add(new Student("마동석",10));
		list.add(new Student("김종국",20));
		list.add(new Student("이정제",48));
		list.add(new Student("이순재",50));
		list.add(new Student("이나영",30));
		
		java.util.Iterator<Student> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			Student std = iterator.next();
			System.out.println("이름 : "+std.getName());
			System.out.println("나이 : "+std.getAge());
			System.out.println("----------------------------");
		}
		
	}

}
