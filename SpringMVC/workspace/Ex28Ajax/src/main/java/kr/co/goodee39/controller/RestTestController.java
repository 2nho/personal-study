package kr.co.goodee39.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.goodee39.vo.DataVO;
import kr.co.goodee39.vo.SampleVO;

@RestController
public class RestTestController {
		
	@GetMapping("/test6")
	public ResponseEntity<ArrayList<SampleVO>> test6(){
		
		ArrayList<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("문자열1",100, 11.11, false));
		list.add(new SampleVO("문자열2",200, 22.22, true));
		list.add(new SampleVO("문자열3",300, 33.33, false));
		
		ResponseEntity<ArrayList<SampleVO>> entry =
				new ResponseEntity<ArrayList<SampleVO>>(list, HttpStatus.OK);
		
		return entry;
	}
	
	@PutMapping("/test7")
	public ResponseEntity<ArrayList<SampleVO>> test7(){
		
		ArrayList<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("문자열1",100, 11.11, false));
		list.add(new SampleVO("문자열2",200, 22.22, true));
		list.add(new SampleVO("문자열3",300, 33.33, false));
		
		ResponseEntity<ArrayList<SampleVO>> entry =
				new ResponseEntity<ArrayList<SampleVO>>(list, HttpStatus.OK);
		
		return entry;
	}
	
	@PostMapping("/test8")
	public HashMap<String,Object> test8(@RequestBody HashMap<String, Object> map){
		
		System.out.println(map.toString());
		
		return map;
	}
	
	@PostMapping("/test9")
	public DataVO test9(@RequestBody DataVO vo){
		
		System.out.println(vo.getData1());
		System.out.println(vo.getData2());
		System.out.println(vo.getData3());
		
		return vo;
	}
}


















