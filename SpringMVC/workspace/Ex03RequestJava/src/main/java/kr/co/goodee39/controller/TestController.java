package kr.co.goodee39.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	// GET방식으로 호출했을 시 받는 방법
	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public String test1() {
		return "test1";
	}
	// POST방식으로 호출했을 시 받는 방법
	@RequestMapping(value="/test2", method=RequestMethod.POST)
	public String test2() {
		return "test2";
	}
	// GET과 POST를 둘다 받을려면?
	@RequestMapping(value="/test3", method=RequestMethod.GET)
	public String test3Get() {
		return "test3_get";
	}
	
	@RequestMapping(value="/test3", method=RequestMethod.POST)
	public String test3Post() {
		return "test3_post";
	}
	
	@RequestMapping(value="/test4", method= {RequestMethod.GET, RequestMethod.POST})
	public String test4() {
		return "test4";
	}
	
	@RequestMapping(value="/test5")
	public String test5() {
		return "test5";
	}
	
	@GetMapping("/test6")
	public String test6() {
		return "test6";
	}
	
	@PostMapping("/test7")
	public String test7() {
		return "test7";
	}
}



