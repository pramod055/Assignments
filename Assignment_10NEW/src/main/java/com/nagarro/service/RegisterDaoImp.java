package com.nagarro.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.nagarro.model.LoginModel;
import com.nagarro.model.RegisterModel;

@Repository("goalRepository")
public class RegisterDaoImp implements RegisterDao {

	@PersistenceContext
	private EntityManager em;
	public RegisterModel add(RegisterModel registermodel) {
		em.persist(registermodel);
		em.flush();
		return registermodel;
	}
	public List<RegisterModel> loadAll() {
		Query query = em.createQuery("Select rg from RegisterModel rg");
		@SuppressWarnings("unchecked")
		List<RegisterModel> users = query.getResultList();
		return users;
	}
	public List<RegisterModel> checkUser(RegisterModel registermodel) {
		
		Query query = em.createQuery("Select rg from RegisterModel rg where rg.userId = '"+registermodel.getUserId()+"'");
		@SuppressWarnings("unchecked")
		List<RegisterModel> user = query.getResultList();
		return user;
	}
	

}
