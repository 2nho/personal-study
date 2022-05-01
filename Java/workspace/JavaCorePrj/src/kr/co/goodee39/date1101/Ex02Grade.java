package kr.co.goodee39.date1101;

import java.util.Scanner;

public class Ex02Grade {

	public static void main(String[] args) {
		// 학점 계산기
		/* - 입력된 정수 값 1~100 사이의 값을 입력받음
		 * - 점수가 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D,
		 *   모두 해당사항이 없다면 F를 출력하는 프로그램을 만들어라
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		
		// System.out.println(score);
		if(score >= 90) {
			System.out.println("A등급 입니다");
		}else if(score >= 80) {
			System.out.println("B등급 입니다");
		}else if(score >= 70) {
			System.out.println("C등급 입니다");
		}else if(score >= 60) {
			System.out.println("D등급 입니다");
		}else {
			System.out.println("F등급 입니다");
		}
	}

}
