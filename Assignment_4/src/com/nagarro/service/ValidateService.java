package com.nagarro.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.RegisterModel;
import com.nagarro.util.HibernateUtil;

public class ValidateService 
{
	public boolean isValidateUser(RegisterModel model)
	{
		boolean result=false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(RegisterModel.class);
		criteria.add(Restrictions.or(Restrictions.eq("loginId",model.getLoginId()),
				     Restrictions.eq("emailAddress", model.getEmailAddress())));
		
		List<RegisterModel> usersList= criteria.list();
		if(usersList.isEmpty())
		{
			result=true;
		}
		else
		{
			result=false;
		}
		return result;	
	}
}
