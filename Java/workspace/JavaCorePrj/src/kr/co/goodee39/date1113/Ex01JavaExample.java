package kr.co.goodee39.date1113;

import java.util.Scanner;

public class Ex01JavaExample {

	public static void main(String[] args) {
		// 자료형
		// 1, 2, 3, 0, -1, -2, -3 => 정수형
		// 0.1, -2.3 => 실수형
		// '각', 'a' => 문자형
		// "안녕하세요" => 문자열형
		// true, false => 논리형(불리언형)
		// 출력
		// 출력을 하고 개행
		System.out.println(1);
		// 출력을 하는데 개행 X
		System.out.print("반갑습니다\n");
		// 데이터와 출력할 문자열을 분리하여 정의
		System.out.printf("저는 %s 입니다\n", "김근형");
		// 변수
		// 정수형
		byte a1 = 1;  // 1 byte
		short a2 = 2;  // 2 byte
		int a3 = 3;  // 4 byte  <- 기본
		long a4 = 4L;  // 8 byte
		// 실수형
		float b1 = 1.4f;  // 4 byte
		double b2 = 2.3;  // 8 byte <- 기본
		// 문자형
		char c1 = '가';  // 2 byte
		// char c2 = '나다'; // error
		// 불리언(논리형)
		boolean d1 = true;  // 1 byte
		boolean d2 = false;
		// 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력>");
		int e1 = scan.nextInt();  // 정수 입력
		System.out.print("실수 입력>");
		double e2 = scan.nextDouble();  // 실수 입력
		System.out.print("문자열 입력>");
		String e3 = scan.next();  // 문자열 입력(스페이스) ex) 나는 집에 갑니다 => 나는
		System.out.print("문자열 입력>");
		String e4 = scan.nextLine(); // 문자열 입력(엔터) ex) 나는 집에 갑니다\n => 나는 집에 갑니다.
	}

}





