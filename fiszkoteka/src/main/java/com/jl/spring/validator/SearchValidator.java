package com.jl.spring.validator;

import javax.validation.constraints.Size;
/**
 * 
 * @author oem1
 * Walidator formularza wyszukiwarki
 */
public class SearchValidator {

	@Size(max=255, message="Liczba znak�w powinna by� mniejsza ni� 255.")
	//tekst do wyszukania
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
