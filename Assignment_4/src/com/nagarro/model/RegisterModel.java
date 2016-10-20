package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class RegisterModel 
{
		@javax.persistence.Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="Id") 
	    private int id;

		@Column(name="loginId") 
    	public String loginId;
	    
	    @Column(name= "password")
		public String password;
	    
	    @Column(name= "firstName")
		public String firstName;
	    
	    @Column(name= "lastName")
		public String lastName;
	    
	    @Column(name= "emailAddress")
		public String emailAddress;
	  
	    @Column(name= "confirmPassword")
	    public String confirmPassword;
	    
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		public String getLoginId() 
		{
			return loginId;
		}
		public void setLoginId(String loginId) 
		{
			this.loginId = loginId;
		}
		public String getPassword() 
		{
			return password;
		}
		public void setPassword(String password) 
		{
			this.password = password;
		}
		public String getFirstName() 
		{
			return firstName;
		}
		public void setFirstName(String firstName) 
		{
			this.firstName = firstName;
		}
		public String getLastName() 
		{
			return lastName;
		}
		public void setLastName(String lastName) 
		{
			this.lastName = lastName;
		}
		public String getEmailAddress() 
		{
			return emailAddress;
		}
		public void setEmailAddress(String emailAddress) 
		{
			this.emailAddress = emailAddress;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
}
