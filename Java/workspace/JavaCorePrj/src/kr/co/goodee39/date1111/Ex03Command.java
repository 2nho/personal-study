package kr.co.goodee39.date1111;

import java.util.Scanner;

public class Ex03Command {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("선택할 메뉴를 정하세요>");
		int num = scan.nextInt();
		
		SystemMode mode = null;
		
		if(num == 1) {
			mode = new FinanceBoard();
		}else if(num == 2) {
			mode = new StockBoard();
		}else if(num == 3) {
			mode = new EmployeeBoard();
		}
		
		mode.getList();
		mode.selectItem();
		mode.updateList();
	}

}
