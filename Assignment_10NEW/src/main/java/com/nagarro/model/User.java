package com.nagarro.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User
{
	int id;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9]*$")
	String username;
	
	@NotNull
	String password;
	
	public User()
	{
		super();
	}
		
	public User(int id, String username, String password)
	{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
