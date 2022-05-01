package kr.co.goodee39.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.goodee39.vo.DataVO;

@Controller
public class BasicController {
	
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
	
	@GetMapping("/test2")
	public @ResponseBody String test2() {
		return "test2";
	}
	
	@GetMapping("/test3")
//	public @ResponseBody ArrayList<String> test3(){
//		ArrayList<String> arr = new ArrayList<String>();
//		arr.add("문자열1");
//		arr.add("문자열2");
//		arr.add("문자열3");
//		
//		return arr;
//	}
	public @ResponseBody ResponseEntity<ArrayList<String>> test3(){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("문자열1");
		arr.add("문자열2");
		arr.add("문자열3");
		
//		ResponseEntity<ArrayList<String>> entry = 
//				new ResponseEntity<ArrayList<String>>(arr, HttpStatus.OK);
		ResponseEntity<ArrayList<String>> entry = 
				new ResponseEntity<ArrayList<String>>(arr, HttpStatus.NOT_FOUND);
		
		return entry;
	}
	
	@GetMapping("/test4")
	public @ResponseBody ResponseEntity<ArrayList<DataVO>> test4(){
		ArrayList<DataVO> arr = new ArrayList<DataVO>();
		arr.add(new DataVO("a1","a2","a3"));
		arr.add(new DataVO("b1","b2","b3"));
		arr.add(new DataVO("c1","c2","c3"));
		
		ResponseEntity<ArrayList<DataVO>> entry = 
				new ResponseEntity<ArrayList<DataVO>>(arr, HttpStatus.OK);
		
		return entry;
	}
	
	@GetMapping("/test5")
	public @ResponseBody ResponseEntity<ArrayList<DataVO>> test5(){
		ArrayList<DataVO> arr = new ArrayList<DataVO>();
		arr.add(new DataVO("a1","a2","a3"));
		arr.add(new DataVO("b1","b2","b3"));
		arr.add(new DataVO("c1","c2","c3"));
		
		ResponseEntity<ArrayList<DataVO>> entry = 
				new ResponseEntity<ArrayList<DataVO>>(arr, HttpStatus.OK);
//		ResponseEntity<ArrayList<DataVO>> entry = 
//				new ResponseEntity<ArrayList<DataVO>>(arr, HttpStatus.NOT_FOUND);
		
		return entry;
	}
}








