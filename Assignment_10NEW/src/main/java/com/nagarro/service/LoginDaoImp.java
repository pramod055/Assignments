package com.nagarro.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.nagarro.model.LoginModel;
import com.nagarro.model.RegisterModel;

@Repository("loginRepository")
public class LoginDaoImp implements LoginDao {
	@PersistenceContext
	private EntityManager em;
	public List<RegisterModel> findUser(LoginModel loginUser) {
		Query query = em.createQuery("Select rg from RegisterModel rg where rg.userId = '"+loginUser.getUserId()+"'");
		@SuppressWarnings("unchecked")
		List<RegisterModel> user = query.getResultList();
		return user;
	}
}
