package kr.co.goodee39.proxy2;

public class PersonProxy implements Person{
	
	private Person person;
	private Before before;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Before getBefore() {
		return before;
	}


	public void setBefore(Before before) {
		this.before = before;
	}


	@Override
	public void doSomething() {
		// 공통관심사항 before
		if(before != null) {
			before.before();
		}
		try {
			// 핵심관심사항
			person.doSomething();
			// 공통관심사항 after-returning
			System.out.println("잠을 잔다.");
		}catch(Exception e) {
			// 공통관심사항 after-throwing
			System.out.println("화재발생 119에 신고한다.");
		}finally {
			// 공통관심사항 after
			System.out.println("문을 열고 집을 나온다.");
		}
	}
	
}
