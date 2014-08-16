package com.jl.spring.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * 
 * @author oem1
 * Klasa odpowiedzialna za walidacj� formularzy dodawania, edycji wi�zki
 */
public class BundleForm {
	
	@NotNull
	@Size(min=3, max=255, message="Liczba znak�w powinna zawiera� si� w przedziale 3 a 255.")
	//nazwa
	private String name;
	
	@NotNull
	//zmienna odpowiedzialna za dost�p do wi�zki, je�li jest true-> oznacza to, �e wi�zka jest wi�zk� publiczn� dost�pn� dla wszystkich, je�li jest false-> wi�zka jest widoczna tylko dla u�ytkownika
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

	public BundleForm(String name, String visible) {
		super();
		this.name = name;
		this.visible = visible;
	}

	public BundleForm() {
		
		this.name = "";
		this.visible= "";
	}

}
