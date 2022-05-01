package kr.co.goodee39.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;
import kr.co.goodee39.beans.TestBean3;
import kr.co.goodee39.beans.TestBean4;
import kr.co.goodee39.beans.TestBean5;
import kr.co.goodee39.config.BeanConfigClass;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean1 t1 = ctx.getBean(TestBean1.class);
		System.out.println("t1 : "+t1);
		
		TestBean1 t2 = ctx.getBean(TestBean1.class);
		System.out.println("t2 : "+t2);
		
		TestBean2 t3 = ctx.getBean("t3", TestBean2.class);
		System.out.println("t3 : "+t3);
		
		TestBean3 t4 = ctx.getBean(TestBean3.class);
		System.out.println("t4 : "+t4);
		
		TestBean4 t5 = ctx.getBean(TestBean4.class);
		System.out.println("t5 : "+t5);
		
		TestBean4 t6 = ctx.getBean(TestBean4.class);
		System.out.println("t5 : "+t6);
		
		System.out.println("-------------------------------------------");
		
		TestBean5 obj1 = ctx.getBean(TestBean5.class);
		System.out.println("obj1.data1" + obj1.getData1());
		System.out.println("obj1.data2" + obj1.getData2());
		System.out.println("obj1.data3" + obj1.getData3());
	}
}
