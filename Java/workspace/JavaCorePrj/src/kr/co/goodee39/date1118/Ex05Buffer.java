package kr.co.goodee39.date1118;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Ex05Buffer {

	public static void main(String[] args) {
		System.out.println("[8바이트 크기로 버퍼 생성]");
		ByteBuffer buffer = ByteBuffer.allocateDirect(8);
		printState(buffer);
		
		buffer.put((byte)10);
		buffer.put((byte)11);
		System.out.println("[2바이트 저장 후]");
		printState(buffer);
		
		buffer.put((byte)12);
		buffer.put((byte)13);
		buffer.put((byte)14);
		System.out.println("[3바이트 저장 후]");
		printState(buffer);
		
		// filp() : limit를 position으로 position을 0으로 이동
		buffer.flip();
		System.out.println("[filp() 실행 후]");
		printState(buffer);
		
		// 3바이트 읽기
		byte[] byte1 = new byte[3];
		buffer.get(byte1);
		for (byte b : byte1) {
			System.out.print(b + " ");
		}
		System.out.println("]");
		printState(buffer);
		
		buffer.mark();
		
		// 2바이트 읽기
		byte[] byte2 = new byte[2];
		buffer.get(byte2);
		for (byte b : byte2) {
			System.out.print(b + " ");
		}
		System.out.println("]");
		printState(buffer);
		
		// reset 실행
		buffer.reset();
		System.out.println("[position reset 후]");
		printState(buffer);
		
		// 다시 읽기
		byte[] byte3 = new byte[2];
		buffer.get(byte3);
		for (byte b : byte3) {
			System.out.print(b + " ");
		}
		System.out.println("]");
		printState(buffer);
		
		// position만 0으로 초기화
		buffer.rewind();
		System.out.println("[rewind() 실행 후]");
		printState(buffer);
		
		// 버퍼의 위치 속성을 초기화
		buffer.clear();
		System.out.println("[clear() 실행 후]");
		printState(buffer);
	}
	
	public static void printState(Buffer buffer) {
		System.out.print("\tposition : "+buffer.position()+ ", ");
		System.out.print("\tlimit : "+buffer.limit()+ ", ");
		System.out.println("\tcapacity : "+buffer.capacity());
	}

}
