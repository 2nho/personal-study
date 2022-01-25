package kr.co.goodee39.date1105;

public class Ex02Singleton {
	public static void main(String[] args) {
		SingletonClass s = new SingletonClass();
		TargetClass t1 = s.getTargetClass();
		System.out.println(t1);
		TargetClass t2 = s.getTargetClass();
		System.out.println(t2);
		TargetClass t3 = s.getTargetClass();
		System.out.println(t3);
	}
}
