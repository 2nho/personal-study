package kr.co.goodee39.ver3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext(
						"kr/co/goodee39/ver3/beans.xml");
		
		Person person = ctx.getBean("girl", Person.class);
		try {
			person.doSomething();
		}catch(Exception e) {
//			e.printStackTrace();
		}
	}

}
