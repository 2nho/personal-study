package kr.co.goodee39.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.goodee39.validator.DataVO1Validator;
import kr.co.goodee39.vo.DataVO1;

@Controller
public class TestController {
	
	@GetMapping("/input_data")
	public String inputData(DataVO1 dataVO1) {
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String inputPro(@Valid DataVO1 dataVO1, BindingResult result) {
		if(result.hasErrors()) {
			return "input_data";
		}
		
		return "input_success";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DataVO1Validator validator1 = new DataVO1Validator();
		binder.addValidators(validator1);
	}
}





