package com.jl.spring.data;

import java.io.Serializable;

public class DBStats implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idstatistic;
    private DBUser users;
    private DBCard cards;
    private Integer allanswers;
    private Integer allcorrect;
    private Integer allincorrect;
	public int getIdstatistic() {
		return idstatistic;
	}
	public void setIdstatistic(int idstatistic) {
		this.idstatistic = idstatistic;
	}
	public DBUser getUsers() {
		return users;
	}
	public void setUsers(DBUser users) {
		this.users = users;
	}
	public DBCard getCards() {
		return cards;
	}
	public void setCards(DBCard cards) {
		this.cards = cards;
	}
	public Integer getAllanswers() {
		return allanswers;
	}
	public void setAllanswers(Integer allanswers) {
		this.allanswers = allanswers;
	}
	public Integer getAllcorrect() {
		return allcorrect;
	}
	public void setAllcorrect(Integer allcorrect) {
		this.allcorrect = allcorrect;
	}
	public Integer getAllincorrect() {
		return allincorrect;
	}
	public void setAllincorrect(Integer allincorrect) {
		this.allincorrect = allincorrect;
	}
	
	public DBStats() {
		super();
	}

}
