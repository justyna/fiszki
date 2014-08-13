package com.jl.spring.data;

import java.io.Serializable;
/**
 * 
 * @author oem1
 * Klasa mapuj�ca tabel� bundles z bazy danych
 */
public class DBBundle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//numer id wi�zki
	private Integer idBundle;
	//nazwa wi�zki
	private String nameBundle;
	//zmienna odpowiedzialna za dost�p do wi�zki, je�li jest true-> oznacza to, �e wi�zka jest wi�zk� publiczn� dost�pn� dla wszystkich, je�li jest false-> wi�zka jest widoczna tylko dla u�ytkownika
	private Boolean visible;
	//true= wi�zka usuni�ta, false= nieusuni�ta
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
