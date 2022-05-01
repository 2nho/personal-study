package kr.co.goodee39.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public void test2Result1(String str1) {
		System.out.println(str1);
	}
	
	public void test2Result2(String id, String pw) {
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
	}
}
