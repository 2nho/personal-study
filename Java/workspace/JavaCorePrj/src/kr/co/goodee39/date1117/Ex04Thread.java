package kr.co.goodee39.date1117;

import java.util.Iterator;

public class Ex04Thread {
	// Thread
	/* - 프로세스 내에서 독립적으로 일을 하는 일의 단위
	 * - 한 프로세스 내에서 독립적으로 일을 처리하고자 할 경우 Java에서 제공하는 Thread를 이용해
	 *   해당 처리가 가능하도록 만들 수 있다.
	 * - Java에서는 쓰레드에 대한 구현을 두가지로 제공을 하며 첫번째는 Thread 클래스를 상속받는 방법,
	 *   두번째는 Runnable이라는 인터페이스를 구현하는 방법 두가지로 제공한다.
	 * - Thread 클래스와 Runnable이라는 인터페이스는 공통적으로 run() 이라는 메서드를 제공한다.
	 * - run() 메서드는 독립적으로 돌리고 싶은 로직을 구현하는 시발점이 되며 run()을 통해 원하는 비동기
	 *   로직 구현이 가능하다.
	 * - Thread와 runnable은 사용방법은 다를지 몰라도 start()라는 메서드를 통해 독립적으로 실행하고자
	 *   하는 로직을 똑같이 실행 가능하다.
	 * 
	 * */
	public static void main(String[] args) {
		SampleThread1 th1 = new SampleThread1();
//		th1.run();
		th1.start();
		Thread th2 = new Thread(new SampleThread2());
		th2.start();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}
