package kr.co.goodee39.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.goodee39.beans.DataBean1;
import kr.co.goodee39.beans.DataBean2;
import kr.co.goodee39.beans.DataBean3;
import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;
import kr.co.goodee39.beans.TestBean3;

@Configuration
public class BeanConfigClass {
	
	@Bean
	public TestBean1 java1() {
		return new TestBean1(200, "문자열2", new DataBean1());
	}
	
	@Bean
	public TestBean1 java2() {
		TestBean1 t1 = new TestBean1();
		t1.setData1(400);
		t1.setData2("문자열4");
		t1.setData3(new DataBean1());
		return t1;
	}
	
	@Bean
	public DataBean2 data1() {
		return new DataBean2();
	}
	
	@Bean
	public DataBean2 data2() {
		return new DataBean2();
	}
	
	@Bean(autowire = Autowire.BY_NAME)
	public TestBean2 java3() {
		return new TestBean2();
	}
	
	@Bean
	public DataBean3 data3() {
		return new DataBean3();
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public TestBean3 java4() {
		return new TestBean3();
	}
	
}



























