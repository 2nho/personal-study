package kr.co.goodee39.date1110;

import java.lang.reflect.Method;

public class Ex08PrintAnnoExample {
	// Annotation
	/* - 주석, 알림, 정합성 검사에 쓰이는 인터페이스
	 * - 실제 기능은 없으며 엘리먼트로만 이루어져 있다.
	 * - 원래 기능은 위와 같지만 자바 버전이 올라가면서 어노테이션을 런타임 영역까지 끌고 갈 수 있게 됨
	 * - 많은 프레임워크 혹은 차세데 플랫폼, 새로 나오는 자바 프레임에서 어노테이션을 적극적으로 사용하기 시작
	 * - 어노테이션에서 선언한 엘리먼트의 값들을 활용해 로직을 유동적으로 쓸 수 있게 됨으로써 어노테이션에 대한
	 *   활용이 예전보다 상당히 발전함
	 * - 스프링 프레임워크에서는 이 어노테이션을 활용한 사례가 상당히 많음
	 * 
	 * */
	public static void main(String[] args) {
		// Service 클래스의 메서드 정보들을 가져옴
		Method[] declareMethod = Service.class.getDeclaredMethods();
		for (Method method : declareMethod) {
			// 각 메소드 마다 PrintAnnotation의 선언 여부 확인
			if(method.isAnnotationPresent(PrintAnnotation.class)) {
				// PrintAnnotation 객체 얻기
				PrintAnnotation pa = method.getAnnotation(PrintAnnotation.class);
				// 메소드 이름 출력
				System.out.println("["+method.getName()+"]");
				// 구분선 출력
				for (int i = 0; i < pa.number(); i++) {
					System.out.print(pa.value());
				}
				System.out.println();
				// 메소드에서 실행하고자 하는 내용 실행
				try {
					method.invoke(new Service());
				}catch(Exception e) {
					e.printStackTrace();
				}
				// 구분선 출력
				for (int i = 0; i < pa.number(); i++) {
					System.out.print(pa.value());
				}
				System.out.println();
			}
		}
	}

}
