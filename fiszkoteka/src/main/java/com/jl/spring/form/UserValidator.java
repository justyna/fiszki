package com.jl.spring.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author oem1
 *	Walidator formularza u�ytkownika
 *
 */
public class UserValidator {

	@NotEmpty(message="Musisz poda� nowe has�o")
	@Size(min=8, max=255, message="Has�o powinno zawiera� si� w przedziale 8 a 255")
	//has�o
	private String pass;
	
	@NotEmpty(message="Musisz wybra� rol�")
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
