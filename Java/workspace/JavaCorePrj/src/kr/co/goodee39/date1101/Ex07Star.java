package kr.co.goodee39.date1101;

import java.util.Scanner;

public class Ex07Star {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		// 입력 => 7
		// 출력
		/*
		 *  *
		 *  **
		 *  ***
		 *  ****
		 *  *****
		 *  ******
		 *  *******
		 * */
		for (int i = 1; i <= a; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
