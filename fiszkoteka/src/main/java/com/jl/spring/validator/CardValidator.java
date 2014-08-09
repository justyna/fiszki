package com.jl.spring.validator;

import javax.validation.constraints.Size;

public class CardValidator {

	@Size(min=3, max=255, message="Liczba znaków powinna zawieraæ siê w przedziale 3 a 255.")
	 private String langword;
	@Size(min=3, max=255, message="Liczba znaków powinna zawieraæ siê w przedziale 3 a 255.")
	 private String langtranslation;
	 private String mp3file="BRAK";
	 private String picture="BRAK";
	 @Size(min=3, max=255, message="Liczba znaków powinna zawieraæ siê w przedziale 3 a 255.")
	 private String definition;
	 @Size(min=3, max=255, message="Liczba znaków powinna zawieraæ siê w przedziale 3 a 255.")
	 private String word;
	 @Size(min=3, max=255, message="Liczba znaków powinna zawieraæ siê w przedziale 3 a 255.")
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
