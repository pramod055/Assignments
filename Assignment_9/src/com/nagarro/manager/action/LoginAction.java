package com.nagarro.manager.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.nagarro.manager.data.Manager;
import com.nagarro.manager.service.HibernateDao;
import com.nagarro.manager.utilities.EmployeeUpdator;
import com.opensymphony.xwork2.ActionSupport;



public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SessionMap<String,String> sessionmap; 
	private Manager manager;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setSession(Map<String, Object> map) {
		   sessionmap=(SessionMap)map;  
		    sessionmap.put("login","true");  
		
	}


	public void validate() {
		if ((StringUtils.isEmpty(manager.getUname())) || (manager.getUname().length() < 5)) {
			addFieldError("manager.uname", "Please enter valid user name");
		}
		if ((StringUtils.isEmpty(manager.getPassword())) || (manager.getPassword().length() < 5)) {
			addFieldError("manager.password", "Please enter valid password");
		}
	}

	public String execute() {
		
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		  
		String s=(String)session.getAttribute("login");  
		if(s!=null && !s.equals("")){  
		
			if (HibernateDao.getHibernateDao().loginValidation(manager.getUname(), manager.getPassword()).size() > 0) {
				EmployeeUpdator.update();
				return SUCCESS;
			} 
		}  
    
		return LOGIN;
	}


	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}


}
