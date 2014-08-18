package com.jl.spring.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author oem1
 * Walidator formularza rejestracji
 */
public class RegisterValidator {

	@NotEmpty(message="Musisz podaæ email")
	@Email(message="Nie poprawny format e-maila")
	//email
	private String email;
	@NotEmpty(message="Podaj has³o")
	@Size(min=8, max=255, message="Liczba znaków has³a powinna siê zawieraæ w przedziale")
	//has³o
	private String password;
	
	@NotEmpty(message="Podaj powtórzone has³o")
	//Wyrazenia regularne????
	@Size(min=8, max=255, message="Liczba znaków has³a powinna siê zawieraæ w przedziale")
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
