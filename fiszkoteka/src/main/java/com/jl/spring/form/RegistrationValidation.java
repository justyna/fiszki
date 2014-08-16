package com.jl.spring.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * 
 * @author oem1
 * W³asny walidator, który sprawdza przy rejestracji czy has³o i jego powtórzenie siê zgadzaj¹
 */
@Component("registatorValidator")
public class RegistrationValidation {

	public boolean supports(Class<?> klass) {
		return RegisterForm.class.isAssignableFrom(klass);
		
	}
	
	public void validate(Object target, Errors errors) {
		RegisterForm registration = (RegisterForm) target;
		if(!registration.getPassword().equals(registration.getRepassword())) {
			errors.rejectValue("password", "matchingPassword.registration.password",
			          "Has³a siê nie zgadzaj¹.");
		}
	}
	
}
