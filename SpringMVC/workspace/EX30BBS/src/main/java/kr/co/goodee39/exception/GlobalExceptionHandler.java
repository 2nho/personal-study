package kr.co.goodee39.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception{
	
	@ExceptionHandler(java.lang.Exception.class)
	public String handleException() {
		return "error";
	}
}
