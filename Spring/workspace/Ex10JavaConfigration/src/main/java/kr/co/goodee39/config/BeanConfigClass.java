package kr.co.goodee39.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;
import kr.co.goodee39.beans.TestBean3;

@Configuration
public class BeanConfigClass {
	
//	<bean id="java1" class="kr.co.goodee39.beans.TestBean1">
	@Bean
	public TestBean1 java1() {
		return new TestBean1();
	}
	
//  <bean id="java111" class="kr.co.goodee39.beans.TestBean1">	
	@Bean(name="java111")
	public TestBean1 java1111() {
		return new TestBean1();
	}
	
//  <bean id="java2" class="kr.co.goodee39.beans.TestBean2" lazy-init="true">	
	@Bean
	@Lazy
	public TestBean2 java2() {
		return new TestBean2();
	}

//  <bean id="java3" class="kr.co.goodee39.beans.TestBean3" scope="prototype">
	@Bean
	@Scope("prototype")
	public TestBean3 java3() {
		return new TestBean3();
	}
}







