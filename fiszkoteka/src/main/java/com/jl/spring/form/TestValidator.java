package com.jl.spring.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



@Component("testValidator")
public class TestValidator implements Validator {
	
	public boolean supports(Class<?> klass) {
		return TestForm.class.isAssignableFrom(klass);
	}
	
	public void validate(Object target, Errors errors) {
		/*TestForm test = (TestForm) target;
		if(!test.getAnswer().equals(test.getCorrectAnswer())) {
			errors.rejectValue("answer", "matchingPassword.test.answer",
			          "Poprawna odpowiedü to:"+test.getCorrectAnswer());
		}*/
	}

}
