package kr.co.goodee39.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;
import kr.co.goodee39.beans.TestBean3;
import kr.co.goodee39.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		// xml을 사용하는 방식
		ClassPathXmlApplicationContext ctx1 =
				new ClassPathXmlApplicationContext(
						"kr/co/goodee39/config/beans.xml");
		
		TestBean1 xml1 = ctx1.getBean("xml1",TestBean1.class);
		System.out.println("xml1 : "+xml1);
		
		TestBean1 xml11 = ctx1.getBean("xml1",TestBean1.class);
		System.out.println("xml11 : "+xml11);
		
		System.out.println("-------------------------------------");
		
		TestBean2 xml2 = ctx1.getBean("xml2",TestBean2.class);
		System.out.println("xml2 : "+xml2);
		
		TestBean2 xml22 = ctx1.getBean("xml2",TestBean2.class);
		System.out.println("xml22 : "+xml22);
		
		System.out.println("-------------------------------------");
		TestBean3 xml3 = ctx1.getBean("xml3",TestBean3.class);
		System.out.println("xml3 : "+xml3);
		
		TestBean3 xml33 = ctx1.getBean("xml3",TestBean3.class);
		System.out.println("xml33 : "+xml33);
		
		System.out.println("-------------------------------------");
		// Java 파일을 사용하는 방식
		AnnotationConfigApplicationContext ctx2 =
				new AnnotationConfigApplicationContext(
						BeanConfigClass.class);
		
		TestBean1 java1 = ctx2.getBean("java1", TestBean1.class);
		System.out.println("java1 : "+java1);
		
		TestBean1 java11 = ctx2.getBean("java1", TestBean1.class);
		System.out.println("java11 : "+java11);
		
		TestBean1 java111 = ctx2.getBean("java111", TestBean1.class);
		System.out.println("java111 : "+java111);
		
		System.out.println("-------------------------------------");
		
		TestBean2 java2 = ctx2.getBean("java2", TestBean2.class);
		System.out.println("java2 : "+java2);
		
		TestBean2 java22 = ctx2.getBean("java2", TestBean2.class);
		System.out.println("java22 : "+java22);
		
		System.out.println("-------------------------------------");
		
		TestBean3 java3 = ctx2.getBean("java3", TestBean3.class);
		System.out.println("java3 : "+java3);
		
		TestBean3 java33 = ctx2.getBean("java3", TestBean3.class);
		System.out.println("java33 : "+java33);

	}

}
