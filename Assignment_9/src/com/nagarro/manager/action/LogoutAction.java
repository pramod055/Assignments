package com.nagarro.manager.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class LogoutAction {
	public String logout(){  
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		  
		session.removeAttribute("login");  
		session.setAttribute("login", "");
	    return "success";  
	}  
}
