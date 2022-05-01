package kr.co.goodee39.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.goodee39.vo.DataVO1;

@Controller
@SessionAttributes({"sessionVO1","sessionVO2"})
public class TestController {
	
	@ModelAttribute("sessionVO1")
	public DataVO1 sessionVO1() {
		return new DataVO1();
	}
	
	@ModelAttribute("sessionVO2")
	public DataVO1 sessionVO2() {
		return new DataVO1();
	}
	
	@GetMapping("/test1")
	public String test1(HttpSession session) {
//	public String test1(HttpServletRequest request) {
//		HttpSession session = request.getSession();
		session.setAttribute("data1", "문자열1");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data1", "문자열2");
		return "redirect:/result1";
	}
	
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("data1", "문자열3");
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result(HttpSession session) {
		String data1 = (String)session.getAttribute("data1");
		System.out.println("data1 : "+data1);
		return "result1";
	}
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		DataVO1 vo1 = new DataVO1();
		vo1.setData1("문자열4");
		vo1.setData2("문자열5");
		
		session.setAttribute("vo1", vo1);
		
		return "test4";
	}
	
	@GetMapping("/result4")
//	public String result4(HttpSession session) {
	public String result4(@SessionAttribute("vo1") DataVO1 vo1) {
//		DataVO1 vo1 = (DataVO1)session.getAttribute("vo1");
		
		System.out.println("vo1.data1 : "+vo1.getData1());
		System.out.println("vo1.data2 : "+vo1.getData2());
		
		return "result4";
	}
	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("sessionVO1") DataVO1 vo1,
						@ModelAttribute("sessionVO2") DataVO1 vo2) {
		vo1.setData1("문자열6");
		vo1.setData2("문자열7");
		
		vo2.setData1("문자열8");
		vo2.setData2("문자열9");
		
		return "test5";
	}
	
	@GetMapping("/result5")
	public String result5(@ModelAttribute("sessionVO1") DataVO1 vo1,
						  @ModelAttribute("sessionVO2") DataVO1 vo2) {
		
		System.out.println("sessionVO1.data1 : "+vo1.getData1());
		System.out.println("sessionVO1.data2 : "+vo1.getData2());
		
		System.out.println("sessionVO2.data1 : "+vo2.getData1());
		System.out.println("sessionVO2.data2 : "+vo2.getData2());
		
		return "result5";
	}
}



















