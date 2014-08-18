package com.jl.spring.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author oem1
 * Klasa odpowiedzialna za walidacjê formularzy dodawania, edycji grupy
 */
public class GroupValidator {
	
	@NotEmpty(message="Nale¿y podaæ nazwê grupy")
	@Size(min=3, max=255, message="Liczba znaków grupy powinna zawieraæ siê w przedziale 3 a 255")
	//nazwa grupy
	private String namegroups;

	public String getNamegroups() {
		return namegroups;
	}

	public void setNamegroups(String namegroups) {
		this.namegroups = namegroups;
	}

	public GroupValidator() {
		super();
	}
	
	

}
