package kr.co.goodee39.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;
import kr.co.goodee39.beans.TestBean3;
import kr.co.goodee39.beans.TestBean4;
import kr.co.goodee39.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx1 =
				new AnnotationConfigApplicationContext(
						BeanConfigClass.class);
		
		TestBean1 obj1 = ctx1.getBean("obj1", TestBean1.class);
		TestBean2 obj2 = ctx1.getBean("obj2", TestBean2.class);
		
		System.out.println("---------------------------------------------");
		
		TestBean3 obj3 = ctx1.getBean("obj3", TestBean3.class);
		System.out.println("obj3.data1 : "+obj3.getData1());
		System.out.println("obj3.data2 : "+obj3.getData2());
		
		System.out.println("---------------------------------------------");
		
		TestBean4 obj4 = ctx1.getBean("obj4", TestBean4.class);
		System.out.println("obj4.data1 : "+obj4.getData100());
		System.out.println("obj4.data2 : "+obj4.getData200());
		
		ctx1.close();
	}

}
