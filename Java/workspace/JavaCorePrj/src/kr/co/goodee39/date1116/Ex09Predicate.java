package kr.co.goodee39.date1116;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ex09Predicate {
	// Predicate
	/*
	 * - 매개변수와 리턴값이 있는 람다 인터페이스
	 * - 메서드는 testXXX()
	 * - 매개변수 값을 통해 boolean 값을 리턴하는 역할을 한다.
	 */
	
	private static List<Student> list = Arrays.asList(
			new Student("홍길동","남자",95,84),
			new Student("장희빈","여자",85,73),
			new Student("김삿갓","남자",62,45),
			new Student("유관순","여자",97,80)
			);
	
	public static double avg(Predicate<Student> pr) {
		int count=0, sum=0;
		for (Student student : list) {
			if(pr.test(student)) {
				count++;
				sum += student.getEngScore();
			}
		}
		return (double) sum / count;
	}
	
	public static void main(String[] args) {
		double maleAvg = avg(t -> t.getGender().equals("남자"));
		System.out.println("남자 평균 영어 점수 : "+maleAvg);
		
		double femaleAvg = avg(t -> t.getGender().equals("여자"));
		System.out.println("여자 평균 영어 점수 : "+femaleAvg);
	}

}





