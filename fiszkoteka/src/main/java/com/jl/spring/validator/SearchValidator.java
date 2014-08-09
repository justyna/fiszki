package com.jl.spring.validator;

import javax.validation.constraints.Size;

public class SearchValidator {

	@Size(max=255, message="Liczba znak�w powinna by� mniejsza ni� 255.")
	private String searchText;

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public SearchValidator() {
		super();
		searchText ="";
	}
	
	
}
