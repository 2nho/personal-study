package kr.co.goodee39.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx
			= new ClassPathXmlApplicationContext(
					"kr/co/goodee39/config/beans.xml");
		
		TestBean1 obj1 = ctx.getBean("obj1", TestBean1.class);
//		System.out.println("obj1 : "+obj1);
		obj1.printData();
		
		System.out.println("----------------------------------------");
		
		TestBean1 obj2 = ctx.getBean("obj2", TestBean1.class);
		obj2.printData();
		
		System.out.println("----------------------------------------");
		
		TestBean1 obj3 = ctx.getBean("obj3", TestBean1.class);
		obj3.printData();
		
		System.out.println("----------------------------------------");
		
		TestBean1 obj4 = ctx.getBean("obj4", TestBean1.class);
		obj4.printData();
		
		System.out.println("----------------------------------------");
		
		TestBean1 obj5 = ctx.getBean("obj5", TestBean1.class);
		obj5.printData();
		
		System.out.println("----------------------------------------");
		
		TestBean1 obj6 = ctx.getBean("obj6", TestBean1.class);
		obj6.printData();
		
		System.out.println("----------------------------------------");
		
		TestBean1 obj7 = ctx.getBean("obj7", TestBean1.class);
		obj7.printData();
		
		System.out.println("----------------------------------------");
		
		TestBean1 obj8 = ctx.getBean("obj8", TestBean1.class);
		obj8.printData();
		
		System.out.println("----------------------------------------");
		
		TestBean2 obj9 = ctx.getBean("obj9", TestBean2.class);
		obj9.printData();
		
		System.out.println("----------------------------------------");
		
		TestBean2 obj10 = ctx.getBean("obj10", TestBean2.class);
		obj10.printData();
		
		ctx.close();
	}

}
