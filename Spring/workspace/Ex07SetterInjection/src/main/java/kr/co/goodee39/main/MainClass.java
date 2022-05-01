package kr.co.goodee39.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.goodee39.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext(
						"kr/co/goodee39/config/beans.xml");
		
//		TestBean t1 = ctx.getBean("t1", TestBean.class);
		TestBean t1 = (TestBean)ctx.getBean("t1");
		System.out.println("t1 : "+t1);
		System.out.println("data1 : "+t1.getData1());
		System.out.println("data2 : "+t1.getData2());
		System.out.println("data3 : "+t1.isData3());
		System.out.println("data4 : "+t1.getData4());
		System.out.println("data5 : "+t1.getData5());
		System.out.println("data6 : "+t1.getData6());

	}

}
