package kr.co.goodee39.date1117;

public class SampleThread2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print("/");
			}
			System.out.println();
		}
	}
	
}
