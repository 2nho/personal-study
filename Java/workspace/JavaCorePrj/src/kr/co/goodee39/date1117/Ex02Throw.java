package kr.co.goodee39.date1117;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02Throw {
	// throws
	/*
	 * - try~catch 문구처럼 예외를 처리할 수 있는 또 다른 방법
	 * - 메소드 선언 옆에 발생할 수 있는 Exception 클래스들을 나열하여 예외를 해당 메서드 내에서 처리하는 것이
	 *   아닌 자신을 호출한 상위 메서드에서 처리하도록 위임하는 역할을 한다.
	 * - throws 만으로는 메소드를 제대로 처리한다고 볼 수 없기 때문에 호출한 상위 메서드에서는 반드시 
	 *   try~catch 문구로 예외를 처리해 주어야 한다.
	 */
	public static void main(String[] args) {
		try {
			method1();
		}catch(Exception e) {
			System.out.println("예외 발생");
		}
	}
	
	public static void method1() throws InputMismatchException, ArrayIndexOutOfBoundsException, Exception{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(n);
	}

}
