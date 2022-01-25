package kr.co.goodee39.date1102;

public class Ex02Sort {

	public static void main(String[] args) {
		int[] a = {5,3,2,1,4};
		// 1. a에서 최소값을 구하라.
		int temp = a[0];
		
		for (int i = 1; i < a.length; i++) {
			if(temp > a[i]) {
				temp = a[i];
			}
		}
		
		System.out.println(temp);
		// 2. a를 오름차순으로 sort시켜라.
		
		for (int i = a.length-1; i > 0 ; i--) {
			for (int j = 0; j < i; j++) {
				if(a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		for (int i : a) {
			System.out.println(i);
		}
	}

}
