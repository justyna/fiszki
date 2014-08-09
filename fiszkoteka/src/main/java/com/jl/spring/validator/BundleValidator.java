package com.jl.spring.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BundleValidator {
	
	@NotNull
	@Size(min=3, max=255, message="Liczba znaków powinna zawieraæ siê w przedziale 3 a 255.")
	private String name;
	
	@NotNull
	private String visible;
	
	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return name;
	}

	public BundleValidator(String name, String visible) {
		super();
		this.name = name;
		this.visible = visible;
	}

	public BundleValidator() {
		
		this.name = "";
		this.visible= "";
	}

}
