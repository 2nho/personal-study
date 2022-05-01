package kr.co.goodee39.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.goodee39.vo.DataVO1;

public class DataVO1Validator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DataVO1.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "data2", "error2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "error3");
		
		DataVO1 vo1 = (DataVO1)target;
		
		String data2 = vo1.getData2();
		String data3 = vo1.getData3();
		
		if(data2.length() > 10) {
			errors.rejectValue("data2", "error4");
		}
		
		if(data3.contains("@") == false) {
			errors.rejectValue("data3", "error5");
		}
	}

}
