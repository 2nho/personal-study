package kr.co.goodee39.date1117;

import java.util.Arrays;
import java.util.List;

public class Ex07Pipeline {
	// Stream
	/*
	 * - Java8에서 등장한 반복자를 처리하기 위한 메서드
	 * - 기존의 foreach를 통해서 반복자를 처리하는 것과 달리 더 많은 기능을 제공해주는 라이브러리
	 * - 기존 람다식과 리스트 형태의 데이터가 만나서 데이터의 필터링, 연산등을 메서드로 수행 가능하도록
	 *   만들어준다.
	 * - 최근 들어 상당히 사용 빈도가 높아졌으며 주로 DB쿼리나 외부 데이터에 대한 필터링 처리 등에서
	 *   사용 되고 있다.
	 */
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍길동", Member.MALE, 30),
				new Member("황진이", Member.FEMALE, 25),
				new Member("신사임당", Member.FEMALE, 43),
				new Member("임꺽정", Member.MALE, 35)
				);
		
		double ageAvg = list.stream()
				.filter(m -> m.getGender()==Member.MALE)
				.mapToInt(Member :: getAge)
				.average()
				.getAsDouble();
		
		System.out.println("남자 평균 나이 : "+ageAvg);
	}

}
