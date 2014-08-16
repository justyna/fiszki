package com.jl.spring.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * 
 * @author oem1
 * Klasa odpowiedzialna za walidacjê formularzy dodawania, edycji wi¹zki
 */
public class BundleForm {
	
	@NotNull
	@Size(min=3, max=255, message="Liczba znaków powinna zawieraæ siê w przedziale 3 a 255.")
	//nazwa
	private String name;
	
	@NotNull
	//zmienna odpowiedzialna za dostêp do wi¹zki, jeœli jest true-> oznacza to, ¿e wi¹zka jest wi¹zk¹ publiczn¹ dostêpn¹ dla wszystkich, jeœli jest false-> wi¹zka jest widoczna tylko dla u¿ytkownika
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
