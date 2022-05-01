package kr.co.goodee39.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.goodee39.beans.JdbcBean;
import kr.co.goodee39.config.BeanConfigClass;
import kr.co.goodee39.mapper.MapperInterface;

public class MainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(
						BeanConfigClass.class);
		
		MapperInterface mapper = ctx.getBean("testMapper", MapperInterface.class);
		
		// insert
//		JdbcBean bean1 = new JdbcBean();
//		bean1.setInt_data(100);
//		bean1.setStr_data("문자열100");
//		mapper.insertData(bean1);
		
//		JdbcBean bean2 = new JdbcBean();
//		bean2.setInt_data(200);
//		bean2.setStr_data("문자열200");
//		mapper.insertData(bean2);
		
		// update
//		JdbcBean bean3 = new JdbcBean();
//		bean3.setInt_data(100);
//		bean3.setStr_data("문자열300");
//		mapper.updataData(bean3);
		
		// delete
		mapper.deleteData(100);
		
		// select
		List<JdbcBean> list1 = mapper.selectData();
		for (JdbcBean jdbcBean : list1) {
			System.out.println("int_data : "+jdbcBean.getInt_data());
			System.out.println("str_data : "+jdbcBean.getStr_data());
			System.out.println("----------------------------------------");
		}
		
		ctx.close();
	}

}
