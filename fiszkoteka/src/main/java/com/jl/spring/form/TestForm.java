package com.jl.spring.form;


import org.hibernate.validator.constraints.NotEmpty;

public class TestForm {

	private Integer idCard;
	
	private String question;
	
	@NotEmpty(message="Podaj odpowiedü")
	private String answer;
	
	//private String correctAnswer;

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

	
	
	public Integer getIdCard() {
		return idCard;
	}

	public void setIdCard(Integer id) {
		this.idCard = id;
	}

/*	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}*/

	public TestForm() {
	}

	@Override
	public String toString() {
		return "TestForm [question=" + question + ", answer=" + answer + "]";
	}
	
	
	
}
