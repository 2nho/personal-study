package kr.co.goodee39.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.goodee39.vo.DataVO1;

@Controller
public class Test2Conroller {
	
	@Autowired
	DataVO1 dataVO1;
	
	@GetMapping("/result2")
	public String result2() {
		System.out.println("dataVO1.data1 : "+dataVO1.getData1());
		System.out.println("dataVO1.data2 : "+dataVO1.getData2());
		
		return "result1";
	}
}
