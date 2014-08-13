package com.jl.spring.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author oem1
 *  Klasa mapuj¹ca tabelê groups z bazy danych
 */
public class DBGroup implements Serializable {
	//id grupy
	private Integer idgroup;
	//nazwa grupy
	private String namegroups;
	// wpisy w tabeli usersgroups ³¹cz¹cej u¿ytkowników z grupami (relacja wiele do wielu)
	private Set<DBUsersGroups> usersgroupses = new HashSet<DBUsersGroups>(0);
	
	public Integer getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(Integer idgroup) {
		this.idgroup = idgroup;
	}
	public String getNamegroups() {
		return namegroups;
	}
	public void setNamegroups(String namegroups) {
		this.namegroups = namegroups;
	}
	public Set<DBUsersGroups> getUsersgroupses() {
		return usersgroupses;
	}
	public void setUsersgroupses(Set<DBUsersGroups> usersgroupses) {
		this.usersgroupses = usersgroupses;
	}
	
	
	public DBGroup() {
		super();
	}

}
