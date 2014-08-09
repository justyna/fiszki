package com.jl.spring.data;

import java.io.Serializable;

public class DBBundle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer idBundle;
	private String nameBundle;
	private Boolean visible;
	private Boolean deleted;
	
	private DBUser users;
	
	public Integer getIdBundle() {
		return idBundle;
	}
	public void setIdBundle(Integer idBundle) {
		this.idBundle = idBundle;
	}
	public String getNameBundle() {
		return nameBundle;
	}
	public void setNameBundle(String nameBundle) {
		this.nameBundle = nameBundle;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public DBUser getUsers() {
		return users;
	}
	public void setUsers(DBUser dbUser) {
		this.users = dbUser;
	}
	/*public DBBundle(Integer idBundle, String nameBundle, Boolean visible,
			DBUser dbUser) {
		super();
		this.idBundle = idBundle;
		this.nameBundle = nameBundle;
		this.visible = visible;
		this.dbUser = dbUser;
	}*/
	public DBBundle() {
		
	}
	

}
