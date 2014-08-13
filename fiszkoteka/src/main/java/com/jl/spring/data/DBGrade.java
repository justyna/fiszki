package com.jl.spring.data;

import java.io.Serializable;

/**
 * 
 * @author oem1
 *  Klasa mapuj¹ca tabelê grades z bazy danych
 */
public class DBGrade implements Serializable {

	private static final long serialVersionUID = 1L;
	//id oceny
	private int idgrades;
	//u¿ytkownik, który jest w³aœcielem oceny
    private DBUser users;
    //za co dosta³ ocenê
    private String forwhat;
    //wartoœæ oceny
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
