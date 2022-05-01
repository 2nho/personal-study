package kr.co.goodee39.ver3a;

import java.util.Random;

public class Girl implements Person{
	@Override
	public String doSomething() throws Exception{
		if(new Random().nextBoolean()) {
			throw new Exception("화재 발생");
		}
		
		System.out.println("드라마를 본다.");
		
		return "girl";
	}
}
