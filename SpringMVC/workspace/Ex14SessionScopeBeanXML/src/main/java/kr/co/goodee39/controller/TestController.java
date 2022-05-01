package kr.co.goodee39.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.goodee39.vo.DataVO1;
import kr.co.goodee39.vo.DataVO2;
import kr.co.goodee39.vo.DataVO3;
import kr.co.goodee39.vo.DataVO4;

@Controller
public class TestController {
	
	@Autowired
	@Lazy
	DataVO1 dataVO1;
	
	@Resource(name="dataVO2")
	@Lazy
	DataVO2 dataVO2;
	
	@Autowired
	@Lazy
	DataVO3 dataVO3;
	
	@Resource(name="dataVO4")
	@Lazy
	DataVO4 dataVO4;
	
	@GetMapping("/test1")
	public String test1() {
		dataVO1.setData1("문자열1");
		dataVO1.setData2("문자열2");
		
		dataVO2.setData3("문자열3");
		dataVO2.setData4("문자열4");
		
		dataVO3.setData5("문자열5");
		dataVO3.setData6("문자열6");
		
		dataVO4.setData7("문자열7");
		dataVO4.setData8("문자열8");
		
		return "test1";
	}
	
	@GetMapping("/result1")
//	public String result1(HttpSession session) {
	public String result1(Model model) {
		System.out.println("dataVO1.data1 : "+dataVO1.getData1());
		System.out.println("dataVO1.data2 : "+dataVO1.getData2());
		
		System.out.println("dataVO2.data3 : "+dataVO2.getData3());
		System.out.println("dataVO2.data4 : "+dataVO2.getData4());
		
		System.out.println("dataVO3.data5 : "+dataVO3.getData5());
		System.out.println("dataVO3.data6 : "+dataVO3.getData6());
		
		System.out.println("dataVO4.data7 : "+dataVO4.getData7());
		System.out.println("dataVO4.data8 : "+dataVO4.getData8());
		
		model.addAttribute("dataVO1", dataVO1);
		model.addAttribute("dataVO2", dataVO2);
		model.addAttribute("dataVO3", dataVO3);
		model.addAttribute("dataVO4", dataVO4);
		
		return "result1";
	}
}
