package kr.co.goodee39.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"kr.co.goodee39.beans", "kr.co.goodee39.dao"})
public class BeanConfigClass {
	
	// DataSource
	@Bean
	public BasicDataSource source() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("org.mariadb.jdbc.Driver");
		source.setUrl("jdbc:mariadb://localhost:3306/mydb2");
		source.setUsername("root");
		source.setPassword("1234");
		return source;
	}
	
	// 데이터 베이스에 접속해서 쿼리를 전달하는 빈을 등록
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		return new JdbcTemplate(source);
	}
}
