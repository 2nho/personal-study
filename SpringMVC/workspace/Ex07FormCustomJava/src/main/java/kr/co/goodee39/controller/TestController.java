package kr.co.goodee39.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.goodee39.vo.UserVO;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(UserVO vo) {
		vo.setName("홍길동");
		vo.setId("abcd");
		vo.setPw("1234");
		vo.setPostcode("12345");
		vo.setAddress1("서울시 구로구");
		vo.setAddress2("구로동");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(UserVO vo) {
		vo.setName("홍길동");
		vo.setId("abcd");
		vo.setPw("1234");
		vo.setPostcode("12345");
		vo.setAddress1("서울시 구로구");
		vo.setAddress2("구로동");
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute("vo") UserVO vo) {
		vo.setName("홍길동");
		vo.setId("abcd");
		vo.setPw("1234");
		vo.setPostcode("12345");
		vo.setAddress1("서울시 구로구");
		vo.setAddress2("구로동");
		
		return "test3";
	}
	
	@GetMapping("/test4")
	public String test4(Model model) {
		UserVO vo = new UserVO();
		vo.setName("홍길동");
		vo.setId("abcd");
		vo.setPw("1234");
		vo.setPostcode("12345");
		vo.setAddress1("서울시 구로구");
		vo.setAddress2("구로동");
		
		model.addAttribute("vo", vo);
		
		return "test4";
	}
}
