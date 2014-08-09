package com.jl.spring.validator;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserValidator {

	@NotEmpty
	@Size(min=8, max=255)
	private String pass;
	
	@NotEmpty(message="Musisz wybraæ rolê")
	private String role;

	public UserValidator() {
		super();
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
