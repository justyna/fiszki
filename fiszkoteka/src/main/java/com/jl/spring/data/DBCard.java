package com.jl.spring.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DBCard implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idcard;
    private DBBundle bundles;
    private String langword;
    private String langtranslation;
    private String mp3file;
    private String picture;
    private String definition;
    private String word;
    private String translation;
    private Integer numberanswer=0;
    private Integer incorrect=0;
    private Integer correct=0;
    private Set<DBStats> statses = new HashSet<DBStats>(0);

   public DBCard() {
   }

	
   public DBCard(int idcard) {
       this.idcard = idcard;
   }
   public DBCard(int idcard, DBBundle bundles, String langword, String langtranslation, String mp3file, String picture, String definition, String word, String translation, Integer numberanswer, Integer incorrect, Integer correct, Set statses) {
      this.idcard = idcard;
      this.bundles = bundles;
      this.langword = langword;
      this.langtranslation = langtranslation;
      this.mp3file = mp3file;
      this.picture = picture;
      this.definition = definition;
      this.word = word;
      this.translation = translation;
      this.numberanswer = numberanswer;
      this.incorrect = incorrect;
      this.correct = correct;
      this.statses = statses;
   }
  
   public int getIdcard() {
       return this.idcard;
   }
   
   public void setIdcard(int idcard) {
       this.idcard = idcard;
   }
   public DBBundle getBundles() {
       return this.bundles;
   }
   
   public void setBundles(DBBundle bundles) {
       this.bundles = bundles;
   }
   public String getLangword() {
       return this.langword;
   }
   
   public void setLangword(String langword) {
       this.langword = langword;
   }
   public String getLangtranslation() {
       return this.langtranslation;
   }
   
   public void setLangtranslation(String langtranslation) {
       this.langtranslation = langtranslation;
   }
   public String getMp3file() {
       return this.mp3file;
   }
   
   public void setMp3file(String mp3file) {
       this.mp3file = mp3file;
   }
   public String getPicture() {
       return this.picture;
   }
   
   public void setPicture(String picture) {
       this.picture = picture;
   }
   public String getDefinition() {
       return this.definition;
   }
   
   public void setDefinition(String definition) {
       this.definition = definition;
   }
   public String getWord() {
       return this.word;
   }
   
   public void setWord(String word) {
       this.word = word;
   }
   public String getTranslation() {
       return this.translation;
   }
   
   public void setTranslation(String translation) {
       this.translation = translation;
   }
   public Integer getNumberanswer() {
       return this.numberanswer;
   }
   
   public void setNumberanswer(Integer numberanswer) {
       this.numberanswer = numberanswer;
   }
   public Integer getIncorrect() {
       return this.incorrect;
   }
   
   public void setIncorrect(Integer incorrect) {
       this.incorrect = incorrect;
   }
   public Integer getCorrect() {
       return this.correct;
   }
   
   public void setCorrect(Integer correct) {
       this.correct = correct;
   }
   public Set getStatses() {
       return this.statses;
   }
   
   public void setStatses(Set statses) {
       this.statses = statses;
   }
}
