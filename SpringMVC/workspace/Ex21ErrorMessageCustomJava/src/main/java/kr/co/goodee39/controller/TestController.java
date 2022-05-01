package kr.co.goodee39.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.goodee39.vo.DataVO1;

@Controller
public class TestController {
	
	@GetMapping("/input_data")
	public String inputData(DataVO1 dataVO1) {
		return "input_data";
	}
	
	@PostMapping("/input_success")
	public String inputSuccess(@Valid DataVO1 dataVO1, BindingResult result) {
		
		// 유효성 검사에서 위반된 부분이 있다면...
		if(result.hasErrors()) {
			// 유효성 위반 결과를 전부 가져온다.
			return "input_data";
		}
		
		return "input_success";
	}
}
