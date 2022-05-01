package kr.co.goodee39.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import kr.co.goodee39.mapper.MapperInterface;

// 프로젝트 작업 시 사용할 bean을 정의하는 클래스
@Configuration

@PropertySource("/WEB-INF/properties/db.properties")
public class RootAppContext {
	
	@Value("${db.classname}")
	private String classname;
	
	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
	// 데이터베이스 접속 정보 관리
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(classname);
		source.setUrl(url);
		source.setUsername(username);
		source.setPassword(password);
		
		return source;
	}
	
	// 쿼리문과 접속 관리를 위한 객체
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}
	
	// 쿼리문 실행을 위한 객체
	@Bean
	public MapperFactoryBean<MapperInterface> testMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<MapperInterface> factoryBean = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	// 트랜잭션 설정 객체 1
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	// 트랜잭션 설정 객체 2
	@Bean
	public TransactionTemplate transactionTemplate() {
		return new TransactionTemplate(transactionManager());
	}
	
}














