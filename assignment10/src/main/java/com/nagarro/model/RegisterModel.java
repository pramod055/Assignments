package com.nagarro.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RegisterModel 
{        
	 
		private String userName;
		 @Id
		private String userId;
	    private String emailAddress;
		private String password;
		public String getEmailAddress() 
		{
			return emailAddress;
		}
		
		public String getPassword() 
		{
			return password;
		}
		public String getUserId() 
		{
			return userId;
		}
		public String getUserName() 
		{
			return userName;
		}
		public void setEmailAddress(String emailAddress) 
		{
			this.emailAddress = emailAddress;
		}
		public void setPassword(String password) 
		{
			this.password = password;
		}
		public void setUserId(String userId) 
		{
			this.userId = userId;
		}
		public void setUserName(String userName) 
		{
			this.userName = userName;
		}
	
		
}
