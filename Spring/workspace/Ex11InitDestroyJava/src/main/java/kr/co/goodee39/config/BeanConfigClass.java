package kr.co.goodee39.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import kr.co.goodee39.beans.TestBean1;

public class BeanConfigClass {
	
//  <bean id="xml1" class="kr.co.goodee39.beans.TestBean1" lazy-init="true"
//   init-method="init" destroy-method="destroy"/>
	@Bean(initMethod ="init", destroyMethod="destroy")
	@Lazy
	public TestBean1 java1() {
		return new TestBean1();
	}
}
