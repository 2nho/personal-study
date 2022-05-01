package kr.co.goodee39.model;

import javax.servlet.http.HttpServletRequest;

public class MainService {
	
	public void mainMethod(HttpServletRequest request) {
		request.setAttribute("talk", "hello");
	}
}
