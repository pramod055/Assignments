package com.nagarro.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nagarro.model.RegisterModel;
import com.nagarro.util.HibernateUtil;

public class UserDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();

	public void addUserDetails(RegisterModel model) {
		// TODO Auto-generated method stub
		try 
		{
			session.beginTransaction();
			session.save(model);
			session.getTransaction().commit();
			System.out.println("Details addes Successfully");
		} catch (HibernateException e) 
		{
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		session.close();
	}

}
