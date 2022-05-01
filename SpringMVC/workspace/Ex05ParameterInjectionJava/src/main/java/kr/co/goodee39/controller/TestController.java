package kr.co.goodee39.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.goodee39.vo.DataVO1;
import kr.co.goodee39.vo.DataVO2;

@Controller
public class TestController {
	
	// Collection으로 받는 방법
	@GetMapping("/test1")
	public String test1(@RequestParam Map<String,String> map,
						@RequestParam List<String> data3) {
		
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		String data33 = map.get("data3");
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		System.out.println("data3 : "+data33);
		
		for (String string : data3) {
			System.out.println("data3 result : "+string);
		}
		
		return "result";
	}
	
	// VO 객체로 받는 방법
	@GetMapping("/test2")
//	public String test2(@ModelAttribute DataVO1 vo1,
//						@ModelAttribute DataVO2 vo2) {
	public String test2(DataVO1 vo1, DataVO2 vo2) {
		
		System.out.println("vo1.data1 : "+vo1.getData1());
		System.out.println("vo1.data2 : "+vo1.getData2());
		
		for (int number : vo1.getData3()) {
			System.out.println("vo1.data3 : "+number);
		}
		
		System.out.println("vo2.data1 : "+vo2.getData1());
		System.out.println("vo2.data2 : "+vo2.getData2());
		
		return "result";
	}
}




