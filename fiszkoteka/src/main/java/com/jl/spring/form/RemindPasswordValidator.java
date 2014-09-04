package com.jl.spring.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RemindPasswordValidator {
	
	@Email(message="Nie poprawny format emaila")
	@NotEmpty(message="Musisz poda� adres email")
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RemindPasswordValidator() {
	}
	
	
	

}
