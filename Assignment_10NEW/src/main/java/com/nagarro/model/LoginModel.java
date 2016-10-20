package com.nagarro.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class LoginModel 
{
	
	@NotBlank(message="Please Enter UserId !!!")
	@Pattern(regexp="^[a-zA-Z0-9]*$")
	private String userId;
	
	@NotBlank(message="Please Enter Password !!!")
	private String password;
	
	public String getPassword() {
		return password;
	}
	public String getUserId() {
		return userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


}
