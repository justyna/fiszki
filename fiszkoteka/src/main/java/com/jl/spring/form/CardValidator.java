package com.jl.spring.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author oem1
 * Klasa odpowiedzialna za walidacj� formularzy dodawania, edycji fiszek
 */
public class CardValidator {

	@NotEmpty(message="Nale�y poda� j�zyk originalnego s�owa")
	@Size(min=3, max=255, message="Liczba znak�w powinna zawiera� si� w przedziale 3 a 255.")
	//j�zyk s�owa
	 private String langword;
	
	@NotEmpty(message="Nale�y poda� j�zyk t�umaczenia")
	@Size(min=3, max=255, message="Liczba znak�w powinna zawiera� si� w przedziale 3 a 255.")
	//j�zyk t�umaczenia 
	private String langtranslation;
	//�cie�ka do pliku z nagraniem wymowy
	 private String mp3file="BRAK";
	 //�cie�ka do pliku z obrazkiem
	 private String picture="BRAK";
	 
	 @Size(min=3, max=255, message="Liczba znak�w powinna zawiera� si� w przedziale 3 a 255.")
	//definicja
	 private String definition;
	 @NotEmpty(message="Nale�y poda� s�owo")
	 @Size(min=3, max=255, message="Liczba znak�w powinna zawiera� si� w przedziale 3 a 255.")
	 //s�owo
	 private String word;
	 
	 @NotEmpty(message="Nale�y poda� t�umaczenie s�owa")
	 @Size(min=3, max=255, message="Liczba znak�w powinna zawiera� si� w przedziale 3 a 255.")
	 //t�umaczenie
	 private String translation;
	 
	 
	 
	 public CardValidator(String langword, String langtranslation, String mp3file,
			String picture, String definition, String word, String translation) {
		super();
		this.langword = langword;
		this.langtranslation = langtranslation;
		this.mp3file = mp3file;
		this.picture = picture;
		this.definition = definition;
		this.word = word;
		this.translation = translation;
	}

	 public CardValidator() {
			this.langword = "";
			this.langtranslation = "";
			this.mp3file = "";
			this.picture = "";
			this.definition = "";
			this.word = "";
			this.translation = "";
		}



		public String getLangword() {
			return langword;
		}



		public void setLangword(String langword) {
			this.langword = langword;
		}



		public String getLangtranslation() {
			return langtranslation;
		}



		public void setLangtranslation(String langtranslation) {
			this.langtranslation = langtranslation;
		}



		public String getMp3file() {
			return mp3file;
		}



		public void setMp3file(String mp3file) {
			this.mp3file = mp3file;
		}



		public String getPicture() {
			return picture;
		}



		public void setPicture(String picture) {
			this.picture = picture;
		}



		public String getDefinition() {
			return definition;
		}



		public void setDefinition(String definition) {
			this.definition = definition;
		}



		public String getWord() {
			return word;
		}



		public void setWord(String word) {
			this.word = word;
		}



		public String getTranslation() {
			return translation;
		}



		public void setTranslation(String translation) {
			this.translation = translation;
		}



		@Override
		 public String toString(){
			return langword;
			 
		 }
}
