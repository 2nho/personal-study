package kr.co.goodee39.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.goodee39.beans.DataBean;
import kr.co.goodee39.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext(
						"kr/co/goodee39/config/beans.xml");
		
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		
		List<String> list1 = t1.getList1();
		for (String string : list1) {
			System.out.println("list1 : "+string);
		}
		
		System.out.println("---------------------------------");
		
		List<Integer> list2 = t1.getList2();
		for (Integer integer : list2) {
			System.out.println("list2 : "+integer);
		}
		
		System.out.println("---------------------------------");
		
		List<DataBean> list3 = t1.getList3();
		for (DataBean dataBean : list3) {
			System.out.println("list3 : "+dataBean);
		}
		
		System.out.println("---------------------------------");
		
		Set<String> set1 = t1.getSet1();
		for (String string : set1) {
			System.out.println("set1 : "+string);
		}
		
		System.out.println("---------------------------------");
		
		Set<Integer> set2 = t1.getSet2();
		for (Integer integer: set2) {
			System.out.println("set2 : "+integer);
		}
		
		System.out.println("---------------------------------");
		
		Set<DataBean> set3 = t1.getSet3();
		for (DataBean dataBean : set3) {
			System.out.println("set3 : "+dataBean);
		}
		
		System.out.println("---------------------------------");
		
		Map<String, Object> map1 = t1.getMap1();
		
		String a1 = (String)map1.get("a1");
		int a2 = (Integer)map1.get("a2");
		DataBean a3 = (DataBean)map1.get("a3");
		DataBean a4 = (DataBean)map1.get("a4");
		List<String> a5 = (List<String>)map1.get("a5");
		
		System.out.println("map1/a1 : "+a1);
		System.out.println("map1/a2 : "+a2);
		System.out.println("map1/a3 : "+a3);
		System.out.println("map1/a4 : "+a4);
		
		for (String string : a5) {
			System.out.println("map1/a5 : "+string);
		}
	}

}
