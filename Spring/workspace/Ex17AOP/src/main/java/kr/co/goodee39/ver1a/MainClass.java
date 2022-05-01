package kr.co.goodee39.ver1a;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext(
						"kr/co/goodee39/ver1a/beans.xml");
		
		Person person = ctx.getBean("girl", Person.class);
		person.doSomething();
	}
}
