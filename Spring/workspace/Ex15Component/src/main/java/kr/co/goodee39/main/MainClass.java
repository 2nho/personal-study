package kr.co.goodee39.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;
import kr.co.goodee39.beans2.TestBean3;
import kr.co.goodee39.beans2.TestBean4;
import kr.co.goodee39.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/goodee39/config/beans.xml");
		
		System.out.println("-------------------------------------------");
		
		TestBean1 xml1 = ctx1.getBean(TestBean1.class);
		System.out.println("xml1 : "+xml1);
		
		TestBean2 xml2 = ctx1.getBean("xml2",TestBean2.class);
		System.out.println("xml2 : "+xml2);
		
		TestBean2 xml3 = ctx1.getBean("xml3",TestBean2.class);
		System.out.println("xml3 : "+xml3);
		
		System.out.println("-------------------------------------------");
		
		TestBean3 xml4 = ctx1.getBean(TestBean3.class);
		System.out.println("xml4 : "+xml4);
		
		TestBean4 xml5 = ctx1.getBean("bean4", TestBean4.class);
		System.out.println("xml5 : "+xml5);
		
		System.out.println("-------------------------------------------");
		
		ctx1.close();
		
		System.out.println("=============================================");
		
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		System.out.println("-------------------------------------------");
		
		TestBean1 java1 = ctx2.getBean(TestBean1.class);
		System.out.println("java1 : "+java1);
		
		TestBean2 java2 = ctx2.getBean("java2",TestBean2.class);
		System.out.println("java2 : "+java2);
		
		TestBean2 java3 = ctx2.getBean("java3",TestBean2.class);
		System.out.println("java3 : "+java3);
		
		System.out.println("-------------------------------------------");
		
		TestBean3 java4 = ctx2.getBean(TestBean3.class);
		System.out.println("java4 : "+java4);
		
		TestBean4 java5 = ctx2.getBean("bean4", TestBean4.class);
		System.out.println("java5 : "+java5);
		
		System.out.println("-------------------------------------------");
		
		ctx2.close();
		
	}

}
