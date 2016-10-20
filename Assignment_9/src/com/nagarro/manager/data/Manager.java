package com.nagarro.manager.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGER")

public class Manager {

	  @Id @GeneratedValue
private int idmanager;
	  
private String uname;
private String password;
public int getManagerId() {
	return idmanager;
}
public void setManagerId(int managerId) {
	this.idmanager = managerId;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
