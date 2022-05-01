package kr.co.goodee39.ver2;

import java.util.Random;

public class Boy implements Person{
	@Override
	public String doSomething() throws Exception{
		if(new Random().nextBoolean()) {
			throw new Exception("화재 발생");
		}
		
		System.out.println("컴퓨터로 게임을 한다.");
		
		return "boy";
	}
}
