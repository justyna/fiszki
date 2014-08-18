package com.jl.spring.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class TestForm {

	private Integer id;
	
	private String question;
	
	@NotEmpty(message="Podaj has³o")
	private String answer;
	
	private String correctAnswer;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public TestForm() {
	}

	@Override
	public String toString() {
		return "TestForm [question=" + question + ", answer=" + answer + "]";
	}
	
	
	
}
