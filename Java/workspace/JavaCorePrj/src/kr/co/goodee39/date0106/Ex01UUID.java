package kr.co.goodee39.date0106;

import java.util.Iterator;
import java.util.UUID;

public class Ex01UUID {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			String str = UUID.randomUUID().toString();
			
			System.out.println(str);
		}
		
	}
}
