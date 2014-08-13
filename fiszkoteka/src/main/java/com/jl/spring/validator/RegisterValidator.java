package com.jl.spring.validator;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class RegisterValidator {

	@Email
	private String email;
	@Size(min=8, max=255)
	private String password;
	
	//Wyrazenia regularne????
	@Size(min=8, max=255)
	private String repassword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	public RegisterValidator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegisterValidator(String email, String password, String repassword) {
		super();
		this.email = email;
		this.password = password;
		this.repassword = repassword;
	}
	@Override
	public String toString() {
		return "Register [email=" + email + ", password=" + password
				+ ", repassword=" + repassword + "]";
	}
}