package kr.co.goodee39.proxy2;

public class BeforeImpl implements Before{

	@Override
	public void before() {
		System.out.println("문을 열고 집에 들어간다.");	
	}
	
}
