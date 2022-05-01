package kr.co.goodee39.date1101;

import java.util.Random;

public class Ex04Random {

	public static void main(String[] args) {
		double d = Math.random();
		System.out.println(d);
		
		// 0.9999~0.0001 * 6 = 5.9999 ~ 0.00006 (int)=> 5 ~ 0 + 1 => 6 ~ 1 
		
		int i = (int)(Math.random()*6)+1;
		System.out.println(i);
		
		
		Random ran = new Random();
		
		// 0.00000 ~ 0.99999
		System.out.println(ran.nextDouble());
		// 정수형 int 최소부터 int 최대까지 출력
		System.out.println(ran.nextInt());
		// 정수형 int의 0부터 지정한 범위만큼 출력
		System.out.println(ran.nextInt(6)+3);
		// 논리형의 두가지 값만을 랜덤하게 출력
		System.out.println(ran.nextBoolean());
		
		
		
	}

}
