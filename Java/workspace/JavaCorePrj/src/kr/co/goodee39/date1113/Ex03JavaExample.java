package kr.co.goodee39.date1113;

import java.util.Iterator;

public class Ex03JavaExample {

	public static void main(String[] args) {
		// 배열
		int[] a1 = new int[5];
		int[] a2 = {1,2,3,4,5};
		
//		for (int i = 0; i < a2.length; i++) {
//			System.out.println(a2[i]);
//		}
		
		for (int i : a2) {
			System.out.println(i);
		}
		
		// 다차원 배열
		int[][] a3 = {{1,2,3},{4,5,6}};
		int a4[][] = {{1,2},{3,4},{5,6,7}};
		
		for (int i = 0; i < a4.length; i++) {
			for (int j = 0; j < a4[i].length; j++) {
				System.out.println(a4[i][j]);
			}
		}
	}

}
