package kr.co.goodee39.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
	
	@ExceptionHandler(java.lang.NullPointerException.class)
	public String handleException() {
		return "error2";
	}
	
	@ExceptionHandler(java.lang.Exception.class)
	public String GlobalException() {
		return "error3";
	}
}
