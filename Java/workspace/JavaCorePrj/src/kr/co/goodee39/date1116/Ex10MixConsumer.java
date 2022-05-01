package kr.co.goodee39.date1116;

import java.util.function.Consumer;

public class Ex10MixConsumer {

	public static void main(String[] args) {
		Consumer<Member> ca = m -> System.out.println("consumerA : " + m.getName());
		
		Consumer<Member> cb = m -> System.out.println("consumerB : " + m.getId());
		
		Consumer<Member> cab = ca.andThen(cb);
		cab.accept(new Member("홍길동","hong", null));
	}

}
