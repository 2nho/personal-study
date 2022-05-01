package kr.co.goodee39.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class TestBean1 {
	private int data1;
	private DataBean1 data2;
	
	// 자동 주입을 맴버변수에 설정한다.
	// 자동으로 setter가 추가되어 setter 메서드를 통해 주입 받게 된다.
	@Autowired
	private DataBean1 data3;
	
	private DataBean1 data4;
	
	// Qualifier : 빈의 id값을 기준으로 주입되게 하는 역할을 수행한다.
	@Autowired
	@Qualifier("obj5")
	private DataBean2 data5;
	
	@Autowired
	@Qualifier("obj6")
	private DataBean2 data6;
	
	// 주입되는 bean이 없어도 상관이 없이 null로 동작할 수 있도록 하는 옵션을
	// required = false를 통해 만들 수 있다.
	@Autowired(required = false)
	@Qualifier("obj7")
	private DataBean2 data7;
	
	public TestBean1() {
		// TODO Auto-generated constructor stub
	}
	
	// 자동 주입을 생성자에 설정한다.
	// xml에서는 해당 주입이 성공적으로 이루어지지만 java의 경우에는 수동으로 입력을 해야만
	// 제대로 적용이 된다.
	@Autowired
	public TestBean1(DataBean1 data4) {
		this.data4 = data4;
	}

	public int getData1() {
		return data1;
	}
	
	public void setData1(int data1) {
		this.data1 = data1;
	}
	public DataBean1 getData2() {
		return data2;
	}
//	해당 데이터를 자동으로 주입받기 위해 쓰는 어노테이션 = autowire
	@Autowired
	public void setData2(DataBean1 data2) {
		this.data2 = data2;
	}

	public DataBean1 getData3() {
		return data3;
	}

	public DataBean1 getData4() {
		return data4;
	}

	public DataBean2 getData5() {
		return data5;
	}

	public DataBean2 getData6() {
		return data6;
	}

	public DataBean2 getData7() {
		return data7;
	}
	
	
}
