package com.nagarro.model;

public class LoginModel 
{
	private Long id;
	private String userId;
	private String password;
	public Long getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getUserId() {
		return userId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


}
