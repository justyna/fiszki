package com.jl.spring.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DBUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer idUser;
	private String pass;
	private String email;
	private String roleUser;
	private Boolean deleted;
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
