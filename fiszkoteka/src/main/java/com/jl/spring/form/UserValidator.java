package com.jl.spring.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author oem1
 *	Walidator formularza u¿ytkownika
 *
 */
public class UserValidator {

	@NotEmpty(message="Musisz podaæ nowe has³o")
	@Size(min=8, max=255, message="Has³o powinno zawieraæ siê w przedziale 8 a 255")
	//has³o
	private String pass;
	
	@NotEmpty(message="Musisz wybraæ rolê")
	//rola
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
