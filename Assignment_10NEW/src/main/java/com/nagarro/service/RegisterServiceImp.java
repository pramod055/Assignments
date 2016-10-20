package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.LoginModel;
import com.nagarro.model.RegisterModel;
@Service
public class RegisterServiceImp implements RegisterService {
 
	@Autowired
	private RegisterDao registerDao;
	@Transactional
	public RegisterModel add(RegisterModel registermodel) {
		return registerDao.add(registermodel);
	}
	@Transactional
	public List<RegisterModel> findAllUsers() {
		return registerDao.loadAll();
	}
	@Transactional
	public boolean validateUser(RegisterModel registermodel) {
		 List<RegisterModel> userIsExists  = registerDao.checkUser(registermodel);
		return  userIsExists.isEmpty();
	}
}
