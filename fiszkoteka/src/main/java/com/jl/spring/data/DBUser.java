package com.jl.spring.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author oem1
 *  Klasa mapuj¹ca tabelê users z bazy danych
 */
public class DBUser implements Serializable{
	private static final long serialVersionUID = 1L;
	//id u¿ytkownika
	private Integer idUser;
	//has³o
	private String pass;
	//email
	private String email;
	//rola u¿ytkownika (NAUCZYCIEL-> ROLE_TEACHER, ADMINISTRATOR-> ROLE_ADMIN, UZYTKOWNIK-> ROLE_USER)
	private String roleUser;
	//czy u¿ytkownik zosta³ usuniêty (TAK-> TRUE, NIE-> FALSE)
	private Boolean deleted;
	//wi¹zki u¿ytkownika
	private Set<DBBundle> bundleses = new HashSet<DBBundle>(0);

	public DBUser() {
	}

	

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Set<DBBundle> getBundleses() {
		return bundleses;
	}

	public void setBundleses(Set<DBBundle> bundleses) {
		this.bundleses = bundleses;
	}

}
