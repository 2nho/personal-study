package kr.co.goodee39.ver1a;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Pointcut("execution(* doSomething())")
	public void myPointcut() {}
	
	@Before("myPointcut()")
	public void before() {
		System.out.println("문을 열고 집에 들어간다.");
	}
	
	@After("myPointcut()")
	public void after() {
		System.out.println("문을 열고 집에 나온다.");
	}
	
	@AfterReturning("myPointcut()")
	public void afterReturning() {
		System.out.println("잠을잔다.");
	}
	
	@AfterThrowing("myPointcut()")
	public void afterThrowing() {
		System.out.println("화재발생 : 119에 신고한다.");
	}
}
