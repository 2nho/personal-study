package kr.co.goodee39.date1116;

import java.util.function.BinaryOperator;

public class Ex13MinByMaxBy {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 95, 84);
		Student s2 = new Student("임꺽정", 84, 77);
		Student s3;
		
		BinaryOperator<Student> bo;
		
		bo = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.getEngScore(), f2.getEngScore()) );
		s3 = bo.apply(s1, s2);
		System.out.println(s3.getName());
		
	}

}
