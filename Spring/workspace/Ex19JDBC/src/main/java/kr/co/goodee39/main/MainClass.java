package kr.co.goodee39.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.goodee39.beans.JdbcBean;
import kr.co.goodee39.config.BeanConfigClass;
import kr.co.goodee39.dao.JdbcDAO;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		JdbcDAO dao = ctx.getBean(JdbcDAO.class);
		
		// insert
//		JdbcBean bean1 = new JdbcBean();
//		bean1.setInt_data(1);
//		bean1.setStr_data("문자열1");
//		dao.insert_data(bean1);
		
//		JdbcBean bean2 = new JdbcBean();
//		bean2.setInt_data(2);
//		bean2.setStr_data("문자열2");
//		dao.insert_data(bean2);
		
//		JdbcBean bean4 = new JdbcBean();
//		bean4.setInt_data(1);
//		bean4.setStr_data("문자열3");
//		dao.update_data(bean4);
		
		dao.delete_data(1);
		
		System.out.println("저장 완료");
		
		// select
		List<JdbcBean> list = dao.select_data();
		
		for(JdbcBean bean3 : list) {
			System.out.println("int_data : "+bean3.getInt_data());
			System.out.println("str_data : "+bean3.getStr_data());
		}
	}

}
