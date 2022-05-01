package kr.co.goodee39.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;
import kr.co.goodee39.beans.TestBean3;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx
			= new ClassPathXmlApplicationContext("kr/co/goodee39/config/beans.xml");
		
		TestBean1 t1 = ctx.getBean("t1", TestBean1.class);
		System.out.println("t1 : "+t1);
		
		System.out.println("----------------------------------------");
		
		TestBean2 t2 = ctx.getBean("t2", TestBean2.class);
		System.out.println("t2 : "+t2);
		
		System.out.println("----------------------------------------");
		
		TestBean3 t3 = ctx.getBean("t3", TestBean3.class);
		System.out.println("t3 : "+t3);
		
		ctx.close();
	}
}
