package kr.co.goodee39.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.goodee39.service.TestService;
import kr.co.goodee39.vo.DataVO1;
import kr.co.goodee39.vo.DataVO2;


@Controller
@RequestMapping("test/")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	//@RequestMapping(method = "get", value = "test1")
	//@GetMapping("test/test1")
	@GetMapping("test1")
	public String test1() {
		return "test/test1";
	}
	
	@GetMapping("test2_get")
	public String test2Get(@RequestParam String str1) {
		testService.test2Result1(str1);
		return "test/test2_get";
	}
	
	@PostMapping("test2_post")
	public String test2Post(@RequestParam String id,
							@RequestParam String pw,
							Model model) {
		testService.test2Result2(id, pw);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "test/test2_post";
	}
	
	@PostMapping("test3_post")
	public String test3Post(DataVO1 vo) {
		return "test/test3_post";
	}
	
	@PostMapping("test4_post")
	public String test4Post(@ModelAttribute("vo") DataVO1 vo) {
		return "test/test4_post";
	}
	
	@PostMapping("test5_post")
	public String test5Post(DataVO1 vo1, DataVO2 vo2) {
		vo1.setId("ffff");
		return "test/test5_post";
	}
	
	@PostMapping("test6_post")
	public String test6Post(@RequestParam Map<String, String> param) {
		System.out.println(param.toString());
		return "test/test6_post";
	}
}







