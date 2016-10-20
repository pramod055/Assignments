package com.nagarro.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.LoginModel;
import com.nagarro.model.RegisterModel;
import com.nagarro.util.HibernateUtil;

public class LoginService 
{
	public boolean userExists(LoginModel loginModel)
	{
		boolean result=false;
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(RegisterModel.class);
		criteria.add(Restrictions.eq("loginId",loginModel.getLoginId()))
		        .add(Restrictions.eq("password",loginModel.getPassword()));
		
		List<LoginModel> user=criteria.list();
		//System.out.println("hiiiiiiiiii");
		if(user.isEmpty())
		{
			result=false;
		}
		else
		{
			result=true;
		}
		return result;
	}
}
 