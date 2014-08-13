package com.jl.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * 
 * @author oem1
 * W�asny walidator, kt�ry sprawdza przy rejestracji czy has�o i jego powt�rzenie si� zgadzaj�
 */
@Component("registatorValidator")
public class RegistrationValidation {

	public boolean supports(Class<?> klass) {
		return RegisterValidator.class.isAssignableFrom(klass);
		
	}
	
	public void validate(Object target, Errors errors) {
		RegisterValidator registration = (RegisterValidator) target;
		if(!registration.getPassword().equals(registration.getRepassword())) {
			errors.rejectValue("password", "matchingPassword.registration.password",
			          "Has�a si� nie zgadzaj�.");
		}
	}
	
}
