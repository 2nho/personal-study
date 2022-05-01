package kr.co.goodee39.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.goodee39.vo.DataVO1;

@Controller
public class TestController {
	
	@Autowired
	ServletContext application;
	
	@GetMapping("/test1")
//	public String test1(HttpServletRequest request) {
//		ServletContext application = request.getServletContext();
	public String test1() {
		
		application.setAttribute("data1", "문자열1");
		
		DataVO1 vo = new DataVO1();
		vo.setData1("data1");
		vo.setData2("data2");
		
		application.setAttribute("vo1", vo);
		
		return "test1";
	}
	
	
	@GetMapping("/result1")
//	public String result1(HttpServletRequest request) {
//		ServletContext application = request.getServletContext();
	public String result1() {
		
		String data1 = (String)application.getAttribute("data1");
		
		System.out.println("data1 : "+data1);
		
		DataVO1 vo1 = (DataVO1)application.getAttribute("vo1");
		
		System.out.println("vo1.data1 : "+vo1.getData1());
		System.out.println("vo1.data2 : "+vo1.getData2());
		
		return "result1";
	}
}
