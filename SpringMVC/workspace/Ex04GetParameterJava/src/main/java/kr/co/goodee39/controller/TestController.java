package kr.co.goodee39.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		
		for (String string : data3) {
			System.out.println("data3 : "+string);
		}
		
		return "result";
	}
	
	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		
		for (String string : data3) {
			System.out.println("data3 : "+string);
		}
		
		return "result";
	}
	
	// WebRequest : Spring에서 지원하는 RequestType
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		
		for (String string : data3) {
			System.out.println("data3 : "+string);
		}
		
		return "result";
	}
	
	// @PathVariable : 우리가 서버로 넘긴 경로를 파라미터로 받을 수 있도록 도와주는 어노테이션
	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable String data1,
						@PathVariable int data2,
						@PathVariable int data3) {
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		System.out.println("data3 : "+data3);
		
		String add = data1 + data2 + data3;
		System.out.println("add : "+add);
		
		return "result";
	}
	
	// @RequestParam : request.getParameter로 받은 데이터를 변수화 하여 인자로 받을 수 있도록 하는 어노테이션
	@GetMapping("/test5")
	public String test5(@RequestParam int data1,
						@RequestParam int data2,
						@RequestParam int[] data3) {
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		
		for (int i : data3) {
			System.out.println("data3 : "+i);
		}
		
		return "result";
	}
	
	// @RequestParam의 value 속성으로 보내는 데이터의 속성명과 변수를 
	// 일치시킬 수 있다.
	@GetMapping("/test6")
	public String test6(@RequestParam(value="data1") int value1,
						@RequestParam(value="data2") int value2,
						@RequestParam(value="data3") int[] value3) {
		
		System.out.println("data1 : "+value1);
		System.out.println("data2 : "+value2);
		
		for (int i : value3) {
			System.out.println("data3 : "+i);
		}
		
		return "result";
	}
	
	// required = false : 굳이 해당 데이터가 필요하지 않을 경우 null로 형을 잡아준다.
	// DefaultValue = 해당 값의 default를 지정한다. 데이터가 오지 않았을 경우 해당
	//                Default 값으로 데이터를 전송받는다.
	@GetMapping("/test7")
	public String test7(@RequestParam int data1,
						@RequestParam(required=false) String data2,
						@RequestParam(defaultValue="0") int data3) {
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		System.out.println("data3 : "+data3);
		
		return "result";
	}
}






