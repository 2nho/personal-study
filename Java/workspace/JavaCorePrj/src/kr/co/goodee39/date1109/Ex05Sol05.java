package kr.co.goodee39.date1109;

public class Ex05Sol05 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if( i % 3 == 0) {
				sum += i;
			}
		}
		
		System.out.println("3의 배수의 합 : "+sum);
	}

}
