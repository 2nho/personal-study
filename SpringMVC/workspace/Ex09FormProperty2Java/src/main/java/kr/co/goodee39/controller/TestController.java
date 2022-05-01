package kr.co.goodee39.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.goodee39.vo.DataBean;
import kr.co.goodee39.vo.KeyValueBean;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(DataBean bean, Model model) {
		bean.setA1("data2");
		bean.setA2("data2");
		bean.setA3("data2");
		bean.setA4("data2");
		
		String[] checkList = {"data1", "data3"};
		bean.setA5(checkList);
		bean.setA6(checkList);
		bean.setA7(checkList);
		bean.setA8(checkList);
		
		bean.setA9("data2");
		bean.setA10("data2");
		bean.setA11("data2");
		bean.setA12("data2");
		
		String[] dataList1 = {"data1","data2","data3"};
		model.addAttribute("dataList1", dataList1);
		
		ArrayList<String> dataList2 = new ArrayList<String>();
		dataList2.add("data1");
		dataList2.add("data2");
		dataList2.add("data3");
		model.addAttribute("dataList2", dataList2);
		
		KeyValueBean keyBean1 = new KeyValueBean();
		KeyValueBean keyBean2 = new KeyValueBean();
		KeyValueBean keyBean3 = new KeyValueBean();
		
		keyBean1.setKey("항목1");
		keyBean1.setValue("data1");
		
		keyBean2.setKey("항목2");
		keyBean2.setValue("data2");
		
		keyBean3.setKey("항목3");
		keyBean3.setValue("data3");
		
		ArrayList<KeyValueBean> dataList3 = new ArrayList<KeyValueBean>();
		dataList3.add(keyBean1);
		dataList3.add(keyBean2);
		dataList3.add(keyBean3);
		
		model.addAttribute("dataList3", dataList3);
		
		return "test1";
	}
}
