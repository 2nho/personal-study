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
	public String inputData() {
		return "input_data";
	}
	
	@PostMapping("/input_success")
	public String inputSuccess(@Valid DataVO1 dataVO1, BindingResult result) {
		
		System.out.println("dataVO1.data1 : "+dataVO1.getData1());
		System.out.println("dataVO2.data2 : "+dataVO1.getData2());
		
		System.out.println("BindingResult : " + result);
		
		// 유효성 검사에서 위반된 부분이 있다면...
		if(result.hasErrors()) {
			// 유효성 위반 결과를 전부 가져온다.
			for(ObjectError obj : result.getAllErrors()) {
				System.out.println("메시지 : "+obj.getDefaultMessage());
				System.out.println("code : "+obj.getCode());
				System.out.println("object name : "+obj.getObjectName());
				
				String[] codes = obj.getCodes();
				for (String string : codes) {
					System.out.println(string);
				}
				
				if(codes[0].equals("Size.dataVO1.data1")) {
					System.out.println("data1은 2~10글자를 담을 수 있습니다.");
				}else if(codes[0].equals("Size.dataVO1.data2")) {
					System.out.println("data2는 100이하의 값만 담을 수 있습니다.");
				}
				
				System.out.println("------------------------------------");
			}
			
			return "input_data";
		}
		
		return "input_success";
	}
}
