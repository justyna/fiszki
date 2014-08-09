package com.jl.spring.data;

import java.io.Serializable;

public class DBGrade implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idgrades;
    private DBUser users;
    private String forwhat;
    private Integer grade;

   public DBGrade() {
   }
  
   public int getIdgrades() {
       return this.idgrades;
   }
   
   public void setIdgrades(int idgrades) {
       this.idgrades = idgrades;
   }
   public DBUser getUsers() {
       return this.users;
   }
   
   public void setUsers(DBUser users) {
       this.users = users;
   }
   public String getForwhat() {
       return this.forwhat;
   }
   
   public void setForwhat(String forwhat) {
       this.forwhat = forwhat;
   }
   public Integer getGrade() {
       return this.grade;
   }
   
   public void setGrade(Integer grade) {
       this.grade = grade;
   }
}
