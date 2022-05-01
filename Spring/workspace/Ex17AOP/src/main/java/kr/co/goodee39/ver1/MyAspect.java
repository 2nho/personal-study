package kr.co.goodee39.ver1;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	public void before(JoinPoint jp) {
		System.out.println("문을 열고 집에 들어간다.");
	}
	
	public void after() {
		System.out.println("문을 열고 집에 나온다.");
	}
	
	public void afterReturning() {
		System.out.println("잠을잔다.");
	}
	
	public void afterThrowing() {
		System.out.println("화재발생 : 119에 신고한다.");
	}
}
