package com.nagarro.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginValidateByCookie extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

		Cookie ck[]=req.getCookies(); 
		if(ck != null){
			for(int i=0;i<ck.length;i++){  
				if(ck[i].getValue().equalsIgnoreCase("LoggedIn"))
				{
					return true;
				} 
			}  
		}

		res.sendRedirect("login.html");
		return false; 
	}
}
