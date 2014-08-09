package com.jl.spring.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GroupValidator {
	
	@NotNull
	@Size(min=3, max=255)
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
