package kr.co.goodee39.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.goodee39.beans.DataBean1;
import kr.co.goodee39.beans.DataBean2;
import kr.co.goodee39.beans.DataBean3;
import kr.co.goodee39.beans.DataBean4;
import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;

@Configuration
public class BeanConfigClass {
	@Bean
	public TestBean1 java1() {
		return new TestBean1(data_bean1());
	}
	
	@Bean
	public DataBean1 data_bean1() {
		return new DataBean1();
	}
	
	@Bean
	public DataBean2 obj5() {
		return new DataBean2();
	}
	
	@Bean
	public DataBean2 obj6() {
		return new DataBean2();
	}
	
	@Bean
	public TestBean2 java2() {
		return new TestBean2(100, "hi", dataBean3(), dataBean4());
	}
	
	@Bean
	public DataBean3 dataBean3() {
		return new DataBean3();
	}
	
	@Bean
	public DataBean4 dataBean4() {
		return new DataBean4();
	}
}














