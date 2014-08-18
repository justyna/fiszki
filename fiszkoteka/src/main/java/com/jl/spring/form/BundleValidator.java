package com.jl.spring.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 
 * @author oem1
 * Klasa odpowiedzialna za walidacjê formularzy dodawania, edycji wi¹zki
 */
public class BundleValidator {
	
	@NotEmpty(message="Nale¿y podaæ nazwê wi¹zki")
	@Size(min=3, max=255, message="Liczba znaków powinna zawieraæ siê w przedziale 3 a 255.")
	//nazwa
	private String name;
	
	@NotEmpty(message="Nale¿y siê zdecydowaæ czy wi¹zka bêdzie widoczna dla wszystkich-> publiczna czy te¿ prywatna")
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
