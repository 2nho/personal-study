package kr.co.goodee39.date1116;

import java.util.function.IntBinaryOperator;

public class Ex08Operator {
	// Operation
	/*
	 * - Operation 인터페이스는 매개변수와 리턴값이 존재하고 applyXXX() 메소드를 가지고 있다.
	 * - 메소드들은 매개값을 이용해 연산을 수행한 후 동일한 타입으로 리턴값을 제공하는 역할을 한다.
	 */
	private static int[] scores = {92, 95, 87};
	
	public static int maxOrMin(IntBinaryOperator op) {
		int result = scores[0];
		for (int i : scores) {
			result = op.applyAsInt(result, i);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int max = maxOrMin((a,b) -> (a>=b)?a:b);
		System.out.println("최대값 : "+max);
		
		int min = maxOrMin((a,b) -> (a<=b)?a:b);
		System.out.println("최소값 : "+min);
	}

}
