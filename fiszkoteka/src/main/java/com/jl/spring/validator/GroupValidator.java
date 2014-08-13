package com.jl.spring.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author oem1
 * Klasa odpowiedzialna za walidacj� formularzy dodawania, edycji grupy
 */
public class GroupValidator {
	
	@NotNull
	@Size(min=3, max=255)
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
