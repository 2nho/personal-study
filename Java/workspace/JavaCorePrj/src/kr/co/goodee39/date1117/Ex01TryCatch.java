package kr.co.goodee39.date1117;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01TryCatch {
	// try~catch 문
	/*
	 * - 예외를 처리하는 대표적인 로직 중 하나
	 * - 예외가 발생할 것 같은 지점을 try문으로 감싸서 정의를 하고 예상 예외가 발생할 경우
	 *   catch 문구에서 처리하도록 실행
	 * - catch 문장은 하나가 아닌 복수개가 올 수 있다.
	 * - catch 문장의 맨 끝에는 Exception이 올 수 있으며 위의 예외 처리에 전부 해당되지 않는
	 *   예외가 발생했을 경우 최종적으로 Exception이 선언된 catch 문장을 실행하여 예외가 
	 *   제대로 처리되지 않는 일이 없도록 한다.
	 * 
	 */
	
	// finally 문
	/*
	 * - 정상적으로 로직이 처리되든 예외가 발생하든 상관없이 무조건 처리되야 하는 로직을 실행
	 *   할 경우 쓰는 문장
	 * - catch문 아래쪽에 선언할 수 있으며 로직에서 예외가 발생하거나 정상적으로 처리가 될 경우
	 *   무조건 마지막에 해당 문구를 실행하도록 강제한다.
	 * - try문과 catch문장에서 강제적으로 로직을 빠져나가는 문장을 실행한다 하더라도 finally
	 *   문장은 반드시 실행된다.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int n = scan.nextInt();
			System.out.println(n);		
		}catch(InputMismatchException e) {
			System.out.println("에러가 발생했습니다.");
		}catch(NullPointerException e2) {
			System.out.println("데이터가 널입니다.");
		}catch(ArrayIndexOutOfBoundsException e3) {
			System.out.println("참조하고자 하는 배열의 영역을 벗어났습니다.");
		}catch(Exception e4) {
			System.out.println("뭔진 모르겠지만 아무튼 예외 발생함");
		}finally {
			System.out.println("무조건 처리되는 로직");
			scan.close();
		}
		
		System.out.println("--------------------");
		method();
	}
	
	public static int method() {
		try {
			return 0;
		}catch(Exception e) {
			return 1;
		}finally {
			System.out.println("리턴이되어도 로직이 무조건 처리됨");
		}
	}

}



