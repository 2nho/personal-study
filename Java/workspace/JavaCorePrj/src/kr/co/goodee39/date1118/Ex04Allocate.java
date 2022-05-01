package kr.co.goodee39.date1118;

import java.nio.ByteBuffer;

public class Ex04Allocate {

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocateDirect(100);
		System.out.println("저장용량 : "+bb.capacity()+" 바이트");
	}

}
