
package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;


@Entity

public class RegisterModel 
{		
		@NotBlank(message="userName should not be blank")
		@Column(name="userName")
		@Pattern(regexp="^[a-zA-Z0-9]*$", message="TEST HERE")
		private String userName;
		@Id
		@NotBlank(message="userId should not be blank")
		@Column(name="userId")
		private String userId;
		
		@NotBlank(message="emailAddress should not be blank")
		@Column(name="emailAddress")
		private String emailAddress;
		
		@NotBlank (message="Please enter password!!!")
		@Column(name="password")
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









































/*package com.nagarro.model;
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
	
		
}*/
