package kr.co.goodee39.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import kr.co.goodee39.beans.DataBean1;
import kr.co.goodee39.beans.DataBean2;
import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;
import kr.co.goodee39.beans.TestBean3;
import kr.co.goodee39.beans.TestBean4;


@Configuration
public class BeanConfigClass {
	
	@Bean(initMethod="init1", destroyMethod = "destroy1")
	@Lazy
	public TestBean1 obj1() {
		return new TestBean1();
	}
	
	@Bean
	@Lazy
	public TestBean2 obj2() {
		return new TestBean2();
	}
	
	@Bean
	public DataBean1 data1() {
		return new DataBean1();
	}
	
	@Bean
	public DataBean2 data2() {
		return new DataBean2();
	}
	
	@Bean
	public TestBean3 obj3() {
		return new TestBean3();
	}
	
	@Bean
	public TestBean4 obj4() {
		return new TestBean4();
	}
	
}














