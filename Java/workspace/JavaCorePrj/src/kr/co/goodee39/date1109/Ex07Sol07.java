package kr.co.goodee39.date1109;

public class Ex07Sol07 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if((4*i+5*j)==60) {
					System.out.println("("+i+","+j+")");
					break;
				}
			}
		}
	}

}
