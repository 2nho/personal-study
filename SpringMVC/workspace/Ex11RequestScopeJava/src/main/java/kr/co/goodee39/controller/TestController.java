package kr.co.goodee39.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.goodee39.vo.DataBean1;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		request.setAttribute("data1", "문자열1");
//		return "redirect:/result1";
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		String data1 = (String)request.getAttribute("data1");
		System.out.println("data1 : "+data1);
		return "result1";
	}
	
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("data2", "문자열2");
		return "forward:/result2";
	}
	
	@GetMapping("/result2")
	public String result2(Model model, HttpServletRequest request) {
		String model_data2 = (String)model.getAttribute("data2");
		System.out.println("model.data2 : "+model_data2);
		String request_data2 = (String)request.getAttribute("data2");
		System.out.println("request.data2 : "+request_data2);
		
		return "result2";
	}
	
	@GetMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("data3", "문자열3");
		return "forward:/result3";
	}
	
	@GetMapping("/result3")
	public String result3(WebRequest request) {
		String data3 = (String)request.getAttribute("data3",WebRequest.SCOPE_REQUEST);
		System.out.println("data3 : "+data3);
		return "result3";
	}
	
	@GetMapping("/test4")
	public ModelAndView test4(ModelAndView mv) {
		mv.addObject("data4", "문자열4");
		mv.setViewName("forward:/result4");
		
		return mv;
	}
	
	@GetMapping("/result4")
	public ModelAndView result4(ModelAndView mv, HttpServletRequest request) {
		String mv_data4 = (String)mv.getModel().get("data4");
		System.out.println("mv_data4 : "+mv_data4);
		String request_data4 = (String)request.getAttribute("data4");
		System.out.println("request_data4 : "+request_data4);
		
		mv.setViewName("result4");
		return mv;
	}
	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("bean1") DataBean1 bean1) {
		bean1.setData1("문자열6");
		bean1.setData2("문자열7");
		
		return "forward:/result5";
	}
	
	@GetMapping("/result5")
//	public String result5(@ModelAttribute("bean1") DataBean1 bean1,
//							WebRequest request) {
//		System.out.println("bean1.data1"+bean1.getData1());
//		System.out.println("bean1.data2"+bean1.getData2());
	public String result5(WebRequest request) {
		DataBean1 data1 = (DataBean1)request.getAttribute("bean1", WebRequest.SCOPE_REQUEST);
		System.out.println("data1.data1 : "+data1.getData1());
		System.out.println("data1.data2 : "+data1.getData2());
		
		return "result5";
	}
}




















