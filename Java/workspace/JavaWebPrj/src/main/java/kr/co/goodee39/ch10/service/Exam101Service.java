package kr.co.goodee39.ch10.service;

import javax.servlet.http.HttpServletRequest;

public class Exam101Service {
	public void getCalc(HttpServletRequest request) {
		int data1 = Integer.parseInt(request.getParameter("data1"));
		int data2 = Integer.parseInt(request.getParameter("data2"));
		String type = request.getParameter("type");
		
		if(type.equals("plus")) {
			request.setAttribute("result", data1+data2);
		}else if(type.equals("minus")) {
			request.setAttribute("result", data1-data2);
		}else if(type.equals("mul")) {
			request.setAttribute("result", data1*data2);
		}else {
			request.setAttribute("result", data1/data2);
		}
	}
}
