package kr.co.goodee39.proxy1;

public class PersonProxy implements Person{
	
	private Person person;
	
	
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	@Override
	public void doSomething() {
		System.out.println("문을 열고 집에 들어간다.");
		try {
			person.doSomething();
			System.out.println("잠을 잔다.");
		}catch(Exception e) {
			System.out.println("화재발생 119에 신고한다.");
		}finally {
			System.out.println("문을 열고 집을 나온다.");
		}
	}
	
}
