package com.jl.spring.data;

import java.io.Serializable;

public class DBUsersGroups implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idug;
     private DBGroup groups;
     private DBUser users;

    public DBUsersGroups() {
    	
    }

	
  
   
    public int getIdug() {
        return this.idug;
    }
    
    public void setIdug(int idug) {
        this.idug = idug;
    }
    public DBGroup getGroups() {
        return this.groups;
    }
    
    public void setGroups(DBGroup groups) {
        this.groups = groups;
    }
    public DBUser getUsers() {
        return this.users;
    }
    
    public void setUsers(DBUser users) {
        this.users = users;
    }

}
