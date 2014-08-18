package com.jl.spring.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author oem1
 *	Klasa odpowiedzialna za walidacj� formularzy dodawania, edycji ocen
 */
public class GradeValidator {

	@Min(value=1, message="Warto�� minimalna oceny to 1") 
	@Max(value=6, message="Warto�� maksymalna oceny to 6") 
	@NotNull(message="Nale�y poda� warto�� oceny w skali od 1 do 6")
	//warto�� oceny
	private Integer grade;
	
	@Size(min=3, max=255, message="Liczba znak�w musi zawiera� si� w przedziale mi�dzy 3 a 255") 
	@NotEmpty(message="Nale�y poda� opis oceny")
	//Opis oceny za co
	private String forwhat;
	
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getForwhat() {
		return forwhat;
	}
	public void setForwhat(String forwhat) {
		this.forwhat = forwhat;
	}
}
