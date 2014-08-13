package com.jl.spring.validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author oem1
 *	Klasa odpowiedzialna za walidacjê formularzy dodawania, edycji ocen
 */
public class GradeValidator {

	@Min(1) @Max(6) @NotNull
	//wartoœæ oceny
	private Integer grade;
	
	@Size(min=3, max=255) @NotNull
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
