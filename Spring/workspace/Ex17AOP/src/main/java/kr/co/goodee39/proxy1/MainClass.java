package kr.co.goodee39.proxy1;

public class MainClass {
	public static void main(String[] args) {
		Person boy = new Boy();
		Person girl = new Girl();
		PersonProxy proxy = new PersonProxy();
		
		proxy.setPerson(girl);
		proxy.doSomething();
	}
}
