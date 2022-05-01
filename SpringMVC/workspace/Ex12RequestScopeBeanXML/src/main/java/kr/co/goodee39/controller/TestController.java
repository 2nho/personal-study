package kr.co.goodee39.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	private DataVO1 requestVO1;
	
	@Resource(name="requestVO2")
	@Lazy
	private DataVO2 requestVO2;
	
	@Autowired
	@Lazy
	private DataVO3 requestVO3;
	
	@Resource(name="requestVO4")
	@Lazy
	private DataVO4 requestVO4;
	
	@GetMapping("/test1")
	public String test1() {
		requestVO1.setData1("문자열1");
		requestVO1.setData2("문자열2");
		
		requestVO2.setData3("문자열3");
		requestVO2.setData4("문자열4");
		
		requestVO3.setData5("문자열5");
		requestVO3.setData6("문자열6");
		
		requestVO4.setData7("문자열7");
		requestVO4.setData8("문자열8");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		System.out.println("requestVO1.data1 : "+requestVO1.getData1());
		System.out.println("requestVO1.data2 : "+requestVO1.getData2());
		
		System.out.println("requestVO2.data3 : "+requestVO2.getData3());
		System.out.println("requestVO2.data4 : "+requestVO2.getData4());
		
		System.out.println("requestVO3.data5 : "+requestVO3.getData5());
		System.out.println("requestVO3.data6 : "+requestVO3.getData6());
		
		System.out.println("requestVO4.data7 : "+requestVO4.getData7());
		System.out.println("requestVO4.data8 : "+requestVO4.getData8());
		
		model.addAttribute("requestVO1", requestVO1);
//		model.addAttribute("requestVO2", requestVO2);
		model.addAttribute("requestVO3", requestVO3);
		model.addAttribute("requestVO4", requestVO4);
		
		return "result1";
	}
}
