package kr.co.goodee39.date1116;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Ex12AndOrNegate {

	public static void main(String[] args) {
		// 2 배수 검사
		IntPredicate pa = a -> a%2 == 0;
		// 3 배수 검사
		IntPredicate pb = a -> a%3 == 0;
		IntPredicate pab;
		boolean result;
		
		// and()
		pab = pa.and(pb);
		result = pab.test(6);
		System.out.println("2의 배수 이면서 3의 배수? : "+result);
		
		// or()
		pab = pa.or(pb);
		result = pab.test(9);
		System.out.println("2의 배수 이거나 3의 배수? : "+result);
		
		// negate()
		pab = pa.negate();
		result = pab.test(8);
		System.out.println("8은 홀수 입니까? : "+result);
		
		// isEqual()
		Predicate<String> pr;
		
		pr = Predicate.isEqual("abcd");
		System.out.println(pr.test("abcd"));
	}

}




