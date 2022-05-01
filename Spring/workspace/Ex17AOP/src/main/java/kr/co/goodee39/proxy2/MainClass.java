package kr.co.goodee39.proxy2;

public class MainClass {
	public static void main(String[] args) {
		Person boy = new Boy();
		Person girl = new Girl();
		PersonProxy proxy = new PersonProxy();
		
		proxy.setBefore(new BeforeImpl());
		
		proxy.setPerson(girl);
		proxy.doSomething();
	}
}
